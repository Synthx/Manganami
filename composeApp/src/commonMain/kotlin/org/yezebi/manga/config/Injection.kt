package org.yezebi.manga.config

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.yezebi.manga.domains.manga.services.MangaService
import org.yezebi.manga.domains.manga.services.impl.MangaServiceImpl
import org.yezebi.manga.service.StorageService
import org.yezebi.manga.service.impl.StorageServiceImpl

val appModule = module {
    singleOf(::StorageServiceImpl) { bind<StorageService>() }
    singleOf(::MangaServiceImpl) { bind<MangaService>() }
}
