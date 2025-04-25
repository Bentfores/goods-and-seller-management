package bentfores.goods.and.seller.management.server.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "supplier_products")
data class SupplierProduct(

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  var id: UUID? = null,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "supplier_id")
  var supplier: Supplier,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  var product: Product
)
