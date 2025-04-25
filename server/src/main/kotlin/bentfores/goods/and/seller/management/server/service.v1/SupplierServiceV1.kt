package bentfores.goods.and.seller.management.server.service.v1

import bentfores.goods.and.seller.management.api.model.ManagementSuppliersInfo
import bentfores.goods.and.seller.management.api.model.NewSupplierInfo
import bentfores.goods.and.seller.management.api.model.SupplierStatusEnum
import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Supplier
import bentfores.goods.and.seller.management.server.data.entity.SupplierProduct
import bentfores.goods.and.seller.management.server.data.repository.ProductRepository
import bentfores.goods.and.seller.management.server.data.repository.SupplierProductRepository
import bentfores.goods.and.seller.management.server.data.repository.SupplierRepository
import bentfores.goods.and.seller.management.server.mapper.v1.SupplierMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.UUID

@Service
class SupplierServiceV1(
  private val supplierRepository: SupplierRepository,
  private val supplierMapper: SupplierMapper,
  private val productRepository: ProductRepository,
  private val supplierProductRepository: SupplierProductRepository
) {

  fun getSuppliers(statuses: List<SupplierStatusEnum>): List<ManagementSuppliersInfo> {
    return supplierMapper.mapToManagementSuppliersInfoList(
      supplierRepository.findSuppliersByStatuses(
        statuses.map {
          supplierMapper.mapToSupplierStatus(
            it
          )
        }
      ),
    )
  }

  @Transactional
  fun patchSuppliers(status: SupplierStatusEnum, suppliers: List<UUID>, article: String?, comment: String?) {
    if (!article.isNullOrBlank()) {
      supplierRepository.updateAllByStatusAndArticle(
        supplierMapper.mapToSupplierStatus(status),
        suppliers,
        article,
        comment
      )
    } else {
      supplierRepository.updateAllByStatus(supplierMapper.mapToSupplierStatus(status), suppliers)
    }
  }

  fun getSuppliersByNames(suppliersName: List<String>): List<ManagementSuppliersInfo> {
    return suppliersName.map { supplier ->
      supplierMapper.mapToManagementSuppliersInfo(
        supplierRepository.findBySupplierName(supplier)
      )
    }
  }

  @Transactional
  fun postSuppliers(
    suppliers: List<NewSupplierInfo>,
    article: String,
    imageUrl: String?,
    productName: String?,
    profitPlace: BigDecimal?
  ) {
    val exists = productRepository.existsProductByArticle(article)
    if (!exists) {
      productRepository.save(
        Product(
          article = article,
          imageUrl = imageUrl!!,
          productName = productName!!,
          profitPlace = profitPlace!!
        )
      )
    }
    val product = productRepository.findProductByArticle(article)

    suppliers.forEach { supplierInfo ->
      val existing = supplierRepository.existsBySupplierName(supplierInfo.name)

      if (!existing) {
        val supplier = supplierRepository.save(
          Supplier(
            supplierUrl = supplierInfo.url,
            supplierName = supplierInfo.name,

            )
        )

        val alreadyLinked = supplierProductRepository.existsBySupplierAndProduct(supplier, product)

        if (!alreadyLinked) {
          supplierProductRepository.save(
            SupplierProduct(
              supplier = supplier,
              product = product
            )
          )
        }
      }
    }

  }
}

