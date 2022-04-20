package xyz.zohre.data.discovery

import xyz.zohre.data.model.Category
import xyz.zohre.domain.FlowRepository

interface ProductRepository: FlowRepository<List<Category>> {}