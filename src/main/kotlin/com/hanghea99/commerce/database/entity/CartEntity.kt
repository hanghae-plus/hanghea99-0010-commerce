package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "CART")
@SequenceGenerator(
    name = "CART_SEQ_GENERATOR",
    sequenceName = "CART_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
open class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ_GENERATOR")
    @NotNull
    @Column(name = "CART_KEY", nullable = false)
    open var cartKey: Long? = null

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = null

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    open var userEntity: UserEntity? = null

    @OneToMany(mappedBy = "cartEntity")
    open var cartItemEntities: MutableSet<CartItemEntity> = mutableSetOf()
}