SELECT
	retail.retail_code,
	retail.retail_name,
	CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1 AS time_span,
	COALESCE (COUNT(DISTINCT(b. ID)), 0) customer_flow,
	CASE COALESCE (COUNT(b. ID), 0)
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (
			round(
				COALESCE (
					CASE b.resa_type
					WHEN 1 THEN
						d.pack_qty
					ELSE
						- 1 * d.pack_qty
					END,
					0
				) * COALESCE (A .resa_price, 0),
				2
			)
		) / COUNT (b. ID),
		4
	)
END customer_unit_price,
 COUNT (DISTINCT(A .goods_id, b. ID)) AS sal_goods_count,
 CASE SUM (COALESCE(A .pack_qty, 0))
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (
			round(
				COALESCE (
					CASE b.resa_type
					WHEN 1 THEN
						d.pack_qty
					ELSE
						- 1 * d.pack_qty
					END,
					0
				) * COALESCE (A .resa_price, 0),
				2
			)
		) / SUM (COALESCE(A .pack_qty, 0)),
		4
	)
END AS goods_unit_price,


 CASE COALESCE (COUNT(DISTINCT(b. ID)), 0)
WHEN 0 THEN
	0
ELSE
	COUNT (DISTINCT(A .goods_id, b. ID)) / CASE COUNT (DISTINCT(b. ID))
WHEN 0 THEN
	1
ELSE
	COUNT (DISTINCT(b. ID))
END
END AS cus_goods_count,

 SUM (
	round(COALESCE(A .goods_qty, 0), 4)
) AS sal_goods_qty,

 SUM (
	round(
		COALESCE (
			CASE b.resa_type
			WHEN 1 THEN
				d.pack_qty
			ELSE
				- 1 * d.pack_qty
			END,
			0
		) * COALESCE (A .unit_price, 0),
		2
	)
) AS receive_money,
 SUM (
	round(
		COALESCE (
			CASE b.resa_type
			WHEN 1 THEN
				d.pack_qty
			ELSE
				- 1 * d.pack_qty
			END,
			0
		) * COALESCE (A .resa_price, 0),
		2
	)
) AS real_money,


 (
	SUM (
		round(
			COALESCE (
				CASE b.resa_type
				WHEN 1 THEN
					d.pack_qty
				ELSE
					- 1 * d.pack_qty
				END,
				0
			) * COALESCE (A .resa_price, 0),
			2
		)
	) - SUM (
		(
			CASE
			WHEN oriBatch.unit_price > 0 THEN
				(
					CASE C .inout_flag
					WHEN 2 THEN
						d.goods_qty * oriBatch.unit_price
					WHEN 1 THEN
						d.goods_qty * oriBatch.unit_price * - 1
					END
				)
			ELSE
				(
					CASE C .inout_flag
					WHEN 2 THEN
						d.goods_qty * batch.unit_price
					WHEN 1 THEN
						d.goods_qty * batch.unit_price * - 1
					END
				)
			END
		)
	)
) AS batch_gross,


 CASE SUM (
	round(
		COALESCE (
			CASE b.resa_type
			WHEN 1 THEN
				d.pack_qty
			ELSE
				- 1 * d.pack_qty
			END,
			0
		) * COALESCE (A .resa_price, 0),
		2
	)
)
WHEN 0 THEN
	NULL
ELSE
	round(
		(
			(
				SUM (
					round(
						COALESCE (
							CASE b.resa_type
							WHEN 1 THEN
								d.pack_qty
							ELSE
								- 1 * d.pack_qty
							END,
							0
						) * COALESCE (A .resa_price, 0),
						2
					)
				) - SUM (
					(
						CASE
						WHEN oriBatch.unit_price > 0 THEN
							(
								CASE C .inout_flag
								WHEN 2 THEN
									d.goods_qty * oriBatch.unit_price
								WHEN 1 THEN
									d.goods_qty * oriBatch.unit_price * - 1
								END
							)
						ELSE
							(
								CASE C .inout_flag
								WHEN 2 THEN
									d.goods_qty * batch.unit_price
								WHEN 1 THEN
									d.goods_qty * batch.unit_price * - 1
								END
							)
						END
					)
				)
			) / SUM (
				round(
					COALESCE (
						CASE b.resa_type
						WHEN 1 THEN
							d.pack_qty
						ELSE
							- 1 * d.pack_qty
						END,
						0
					) * COALESCE (A .resa_price, 0),
					2
				)
			)
		),
		4
	)
END AS batch_gross_rate,



 SUM (
	round(
		(
			CASE
			WHEN oriBatch.unit_price > 0 THEN
				(
					CASE C .inout_flag
					WHEN 2 THEN
						d.goods_qty * oriBatch.unit_price
					WHEN 1 THEN
						d.goods_qty * oriBatch.unit_price * - 1
					END
				)
			ELSE
				(
					CASE C .inout_flag
					WHEN 2 THEN
						d.goods_qty * batch.unit_price
					WHEN 1 THEN
						d.goods_qty * batch.unit_price * - 1
					END
				)
			END
		),
		2
	)
) AS ori_batch_price_money,
 CASE (
	CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
)
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (COALESCE(A .goods_qty, 0)) / (
			CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
		),
		4
	)
END AS day_sal_qty,
 CASE (
	CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
)
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (
			round(
				COALESCE (
					CASE b.resa_type
					WHEN 1 THEN
						d.pack_qty
					ELSE
						- 1 * d.pack_qty
					END,
					0
				) * COALESCE (A .resa_price, 0),
				2
			)
		) / (
			CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
		),
		2
	)
END AS day_sal_money,
 SUM (
	round(
		CASE
		WHEN b.vip_card_id IS NULL THEN
			0
		ELSE
			A .goods_qty
		END,
		4
	)
) AS vip_sal_qty,
 SUM (
	round(
		CASE
		WHEN b.vip_card_id IS NULL THEN
			0
		ELSE
			(
				round(
					COALESCE (
						CASE b.resa_type
						WHEN 1 THEN
							d.pack_qty
						ELSE
							- 1 * d.pack_qty
						END,
						0
					) * COALESCE (A .unit_price, 0),
					2
				)
			)
		END,
		2
	)
) AS vip_receive_money,
 SUM (
	round(
		CASE
		WHEN b.vip_card_id IS NULL THEN
			0
		ELSE
			(
				round(
					COALESCE (
						CASE b.resa_type
						WHEN 1 THEN
							d.pack_qty
						ELSE
							- 1 * d.pack_qty
						END,
						0
					) * COALESCE (A .resa_price, 0),
					2
				)
			)
		END,
		2
	)
) AS vip_real_money,
 round(
	(
		SUM (
			CASE
			WHEN b.vip_card_id IS NULL THEN
				0
			ELSE
				(
					round(
						COALESCE (
							CASE b.resa_type
							WHEN 1 THEN
								d.pack_qty
							ELSE
								- 1 * d.pack_qty
							END,
							0
						) * COALESCE (A .resa_price, 0),
						2
					)
				)
			END
		) - SUM (
			CASE
			WHEN b.vip_card_id IS NULL THEN
				0
			ELSE
				(
					CASE
					WHEN oriBatch.unit_price > 0 THEN
						(
							CASE C .inout_flag
							WHEN 2 THEN
								d.goods_qty * oriBatch.unit_price
							WHEN 1 THEN
								d.goods_qty * oriBatch.unit_price * - 1
							END
						)
					ELSE
						(
							CASE C .inout_flag
							WHEN 2 THEN
								d.goods_qty * batch.unit_price
							WHEN 1 THEN
								d.goods_qty * batch.unit_price * - 1
							END
						)
					END
				)
			END
		)
	),
	2
) AS vip_batch_gross,


 SUM (
	round(
		CASE
		WHEN b.vip_card_id IS NULL THEN
			0
		ELSE
			(
				CASE
				WHEN oriBatch.unit_price > 0 THEN
					(
						CASE C .inout_flag
						WHEN 2 THEN
							d.goods_qty * oriBatch.unit_price
						WHEN 1 THEN
							d.goods_qty * oriBatch.unit_price * - 1
						END
					)
				ELSE
					(
						CASE C .inout_flag
						WHEN 2 THEN
							d.goods_qty * batch.unit_price
						WHEN 1 THEN
							d.goods_qty * batch.unit_price * - 1
						END
					)
				END
			)
		END,
		2
	)
) AS vip_batch_money,


 CASE (
	CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
)
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (
			CASE
			WHEN b.vip_card_id IS NULL THEN
				0
			ELSE
				A .goods_qty
			END
		) / (
			CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
		),
		4
	)
END AS vip_day_sal_qty,



 CASE (
	CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
)
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (
			CASE
			WHEN b.vip_card_id IS NULL THEN
				0
			ELSE
				(
					round(
						COALESCE (
							CASE b.resa_type
							WHEN 1 THEN
								d.pack_qty
							ELSE
								- 1 * d.pack_qty
							END,
							0
						) * COALESCE (A .unit_price, 0),
						2
					)
				)
			END
		) / (
			CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
		),
		2
	)
END AS vip_day_receive_money,

 CASE (
	CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
)
WHEN 0 THEN
	NULL
ELSE
	round(
		SUM (
			CASE
			WHEN b.vip_card_id IS NULL THEN
				0
			ELSE
				(
					round(
						COALESCE (
							CASE b.resa_type
							WHEN 1 THEN
								d.pack_qty
							ELSE
								- 1 * d.pack_qty
							END,
							0
						) * COALESCE (A .resa_price, 0),
						2
					)
				)
			END
		) / (
			CAST (MAX(b.busi_date) AS DATE) - CAST (MIN(b.busi_date) AS DATE) + 1
		),
		2
	)
END AS vip_day_real_money,


 CASE SUM (
	round(
		COALESCE (
			CASE b.resa_type
			WHEN 1 THEN
				d.pack_qty
			ELSE
				- 1 * d.pack_qty
			END,
			0
		) * COALESCE (A .resa_price, 0),
		2
	)
)
WHEN 0 THEN
	NULL
ELSE
	round(
		(
			SUM (
				CASE
				WHEN b.vip_card_id IS NULL THEN
					0
				ELSE
					(
						round(
							COALESCE (
								CASE b.resa_type
								WHEN 1 THEN
									d.pack_qty
								ELSE
									- 1 * d.pack_qty
								END,
								0
							) * COALESCE (A .resa_price, 0),
							2
						)
					)
				END
			) - SUM (
				CASE
				WHEN b.vip_card_id IS NULL THEN
					0
				ELSE
					(
						CASE
						WHEN oriBatch.unit_price > 0 THEN
							(
								CASE C .inout_flag
								WHEN 2 THEN
									d.goods_qty * oriBatch.unit_price
								WHEN 1 THEN
									d.goods_qty * oriBatch.unit_price * - 1
								END
							)
						ELSE
							(
								CASE C .inout_flag
								WHEN 2 THEN
									d.goods_qty * batch.unit_price
								WHEN 1 THEN
									d.goods_qty * batch.unit_price * - 1
								END
							)
						END
					)
				END
			)
		) / SUM (
			round(
				COALESCE (
					CASE b.resa_type
					WHEN 1 THEN
						d.pack_qty
					ELSE
						- 1 * d.pack_qty
					END,
					0
				) * COALESCE (A .resa_price, 0),
				2
			)
		),
		4
	)
END AS vip_batch_gross_rate
FROM
	rsa_resa_dtl A
LEFT JOIN rsa_resa_doc b ON A .doc_id = b. ID
INNER JOIN war_stio_doc C ON C .source_id = A . ID
AND C .source_entity = 'ResaDtl'
LEFT JOIN war_stio_dtl d ON d.doc_id = C . ID
LEFT JOIN pub_pos pos ON d.pos_id = pos. ID
LEFT JOIN rsa_counter_pos counter_pos ON counter_pos.pos_id = pos. ID
LEFT JOIN rsa_counter counter ON counter_pos.counter_id = counter. ID
LEFT JOIN pub_batch batch ON d.batch_id = batch. ID
LEFT JOIN pub_user casher ON b.casher_id = casher. ID
LEFT JOIN pub_user clerk_user ON A .clerk_user_id = clerk_user. ID
LEFT JOIN rsa_shift shift ON b.shift_id = shift. ID
LEFT JOIN pub_batch oriBatch ON batch.ori_batch_id = oriBatch. ID
LEFT JOIN pub_retail retail ON retail. ID = b.retail_id
LEFT JOIN pub_retail_class retail_class ON retail.class_id = retail_class. ID
LEFT JOIN pub_area area ON retail.area_id = area. ID
LEFT JOIN pub_retail_group_dtl groupDtl ON groupDtl.retail_id = retail. ID
LEFT JOIN pub_retail_group_doc groupDoc ON groupDoc. ID = groupDtl.doc_id
LEFT JOIN vip_card vip ON b.vip_card_id = vip. ID
LEFT JOIN vip_card_type card_type ON vip.card_type_id = card_type. ID
LEFT JOIN pub_goods goods ON A .goods_id = goods. ID
LEFT JOIN pub_factory factory ON goods.factory_id = factory. ID
LEFT JOIN pub_goods_class goods_class ON goods.class_id = goods_class. ID
WHERE
	A .special_goods_flag = FALSE
AND b.accountset_id = 1
AND COALESCE (goods.goods_nature, 0) <> 3
AND COALESCE (b.channel, 1) = 1
AND b.busi_date >= '2017-06-01 00:00:00'
AND b.busi_date <= '2017-06-29 23:59:59'
and b.status = 1
GROUP BY
	retail.retail_code,
	retail.retail_name
LIMIT 50 OFFSET 0