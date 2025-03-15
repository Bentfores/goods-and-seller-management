package bentfores.goods.and.seller.management.server.data.entity

import bentfores.goods.and.seller.management.server.data.misc.Auditable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "supplier")
data class Supplier(

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "supplier_id")
  var supplierId: UUID? = null,

  @Column(name = "supplier_url")
  var supplierUrl: String,

  @Column(name = "supplier_name")
  var supplierName: String,

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  var status: SupplierStatus = SupplierStatus.NOT_COOPERATING,

  ) : Auditable() {

  enum class SupplierStatus {
    COOPERATING,
    NOT_COOPERATING,
    BLACKLISTED,
    MESSAGE_SENT
  }
}
