package com.teamdevmaurez.kotlintest.data.repository

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaDao
import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import com.teamdevmaurez.kotlintest.data.network.NetworkConstants.COVER_PARAMETER
import com.teamdevmaurez.kotlintest.data.network.NetworkConstants.INFO_PARAMETER
import com.teamdevmaurez.kotlintest.data.network.retrofit.MangaScraperApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.buffer.android.boilerplate.data.mapper.MangaMapper
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by teamdevmaurez on 21/03/2018.
 */
class MangaRepository @Inject internal constructor(private val mangaScraperApi: MangaScraperApi, private val mangaDao: MangaDao) : MangaRepositoryHelper {

    val mangasMapper = MangaMapper()

    override fun count(): Observable<Int> {
        Timber.d("count()")

        return mangaDao.count().toObservable()
    }

    override fun getMangas(): Observable<List<MangaEntity>> {
        Timber.d("getMangas()")

        return Observable.concatArray(
                getMangasFromDb()/*,
                getMangasFromApi()*/)
    }


    private fun getMangasFromDb(): Observable<List<MangaEntity>> {
        Timber.d("getMangasFromDb()")

        return mangaDao.getMangas().filter { it.isNotEmpty() }
                .toObservable()
                .doOnNext {
                    Timber.d("getMangasFromDb: ${it?.size} manga from DB...")
                }.doOnError {
                    Timber.d("getMangasFromDb:error ${it} ")
                }
    }

    private fun getMangasFromApi(): Observable<List<MangaEntity>> {
        Timber.d("getMangasFromApi()")

        return mangaScraperApi.getMangaList("mangareader.net", COVER_PARAMETER, INFO_PARAMETER)
                .map {
                    val mangaEntities = mutableListOf<MangaEntity>()

                    it.map {
                        mangaEntities.add(mangasMapper.mapToEntity(it))
                    }

                    return@map mangaEntities.toList()
                }
                .doOnNext {
                    Timber.d("getMangasFromApi: manga count ${it?.size}")

                    storeUsersInDb(it)
                }.doOnError {
                    Timber.d("getMangasFromApi:doOnError ${it} ")
                }


    }

    private fun storeUsersInDb(mangas: List<MangaEntity>) {
        Timber.d("storeUsersInDb()")

        Observable.fromCallable { mangaDao.insertMangas(mangas) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    Timber.d("Inserted ${mangas?.size} manga from API in DB...")
                }
    }

}
