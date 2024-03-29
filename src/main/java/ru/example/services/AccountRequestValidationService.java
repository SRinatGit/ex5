package ru.example.services;

import ru.example.constants.ErrorMessage;
import ru.example.controllers.ProductRegisterController;
import ru.example.model.Product;
import ru.example.model.ProductRegister;
import ru.example.model.ProductRegisterType;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class AccountRequestValidationService implements ErrorMessage, ValidationService {
   private static Logger logger = LoggerFactory.getLogger(AccountRequestValidationService.class);
   private final ProductRegisterService productRegisterService;
   private final ProductRegisterTypeService productRegisterTypeService;
   @Autowired
   private EntityManager entityManager;

   @Autowired
   public AccountRequestValidationService(ProductRegisterService productRegisterService, ProductRegisterTypeService productRegisterTypeService) {
      this.productRegisterService = productRegisterService;
      this.productRegisterTypeService = productRegisterTypeService;
   }

   public String isValidRequest(ProductRegisterController.CorporateSettlementAccountRequest request) {
      var response = "";
      if (request.instanceId() == null) {
         response = ERROR_NECESSARY_FIELDS.replaceAll(INSTANCE_ID, "");
      }
      return response;
   }

   public String isExistsByProductIdAndType(ProductRegisterController.CorporateSettlementAccountRequest request) {
      var response = "";
      List<ProductRegister> prWithProductIdAndType = this.productRegisterService.findByProductId(request.instanceId()).stream().filter((x) -> {
                              return x.getProductRegisterType().getRegisterTypeName().equals(request.registryTypeCode());
                                 }).toList();
      if (prWithProductIdAndType.size() > 0) {
         response = ERROR_PR_EXISTS.replaceAll(REGISTRY_TYPE_CODE_VALUE, request.registryTypeCode());
         var idStr = "";

         ProductRegister pr;
         for(Iterator varIter = prWithProductIdAndType.iterator(); varIter.hasNext(); idStr = idStr + pr.getProduct().getId() + ",") {
            pr = (ProductRegister)varIter.next();
         }
         response = response.replaceAll(IDS, idStr);
      }

      return response;
   }

   public String isExistsProductCode(ProductRegisterController.CorporateSettlementAccountRequest request, Product product) {
      var response = "";
      List<ProductRegisterType> prTypes = this.productRegisterTypeService.findAllByValue(product.getProductCodeId());
      var isExists = false;
      Iterator varIter = prTypes.iterator();

      while(varIter.hasNext()) {
         ProductRegisterType prt = (ProductRegisterType)varIter.next();
         if (prt.getValue().equals(request.registryTypeCode())) {
            isExists = true;
            break;
         }
      }

      if (!isExists) {
         response = ERROR_PRODUCT_NOT_FOUND.replaceAll(PRODUCT_CODE, product.getProductCodeId());
         response = response.replaceAll(BD_TABLE_NAME, this.getSchemaAndTableByClass(this.entityManager, ProductRegisterType.class));
      }

      return response;
   }
}
