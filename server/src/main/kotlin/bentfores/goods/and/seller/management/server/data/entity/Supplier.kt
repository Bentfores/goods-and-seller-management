package bentfores.goods.and.seller.management.server.data.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "suppliers")
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

  @Column(name = "comment")
  var comment: String? = null,

  @OneToMany(mappedBy = "supplier", cascade = [CascadeType.ALL], orphanRemoval = true)
  var supplierProducts: List<SupplierProduct> = mutableListOf(),

  @CreatedDate
  @Column(updatable = false, name = "created_at")
  var createdAt: LocalDateTime? = LocalDateTime.now(),

  @LastModifiedDate
  @Column(name = "updated_at")
  var updatedAt: LocalDateTime? = LocalDateTime.now()

) {

  enum class SupplierStatus {
    COOPERATING,
    NOT_COOPERATING,
    BLACKLISTED,
    MESSAGE_SENT,
    WRONG
  }
}
