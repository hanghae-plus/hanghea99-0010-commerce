package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@TableGenerator(
    name = "SELLER_REQUEST_REGISTRATION_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "SELLER_REQUEST_REGISTRATION")
open class SellerRequestRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SELLER_REQUEST_REGISTRATION_SEQ_GENERATOR")
    @NotNull
    @Column(name = "SELLER_REQUEST_REGISTRATION_KEY", nullable = false)
    open var sellerRequestRegistrationKey: Long? = null

    @Size(max = 20)
    @NotNull
    @Column(name = "SELLER_ID", nullable = false, length = 20)
    open var sellerId: String? = null

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELLER_ID", nullable = false)
    open var sellerEntity: SellerEntity? = null

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = null
}