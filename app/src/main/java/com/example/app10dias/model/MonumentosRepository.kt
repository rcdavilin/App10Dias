package com.example.app10dias.model

import com.example.app10dias.R

class MonumentosRepository() {
    fun Monumentos(): List<Monumentos>{

        return  listOf<Monumentos>(

                Monumentos(
                    monumentoTitulo = R.string.Taj_Mahal,
                    monumentoInfo = R.string.InfoTaj_Mahal,
                    imageMonumento = R.drawable.taj_mahal,
                    imageMonumento1 = R.drawable.tajmahal1,
                    imageMonumento2 = R.drawable.tajmahal2,
                    linkWikipedia = R.string.linkTajMahal,
                    linkYoutube = R.string.youtubeTajMahal
                ),
            Monumentos(
                monumentoTitulo = R.string.MurallaChina,
                monumentoInfo = R.string.InfoMurallaChina,
                imageMonumento = R.drawable.muralla,
                imageMonumento1 = R.drawable.muralla1,
                imageMonumento2 = R.drawable.muralla2,
                linkWikipedia = R.string.linkMuralla,
                linkYoutube = R.string.youtubeMuralla

            ),
            Monumentos(
                monumentoTitulo = R.string.TorreEiffel,
                monumentoInfo = R.string.InfoTorreEiffel,
                imageMonumento = R.drawable.eiffel,
                imageMonumento1 = R.drawable.eiffel1,
                imageMonumento2 = R.drawable.eiffel2,
                linkWikipedia = R.string.linkEiffel,
                linkYoutube = R.string.youtubeEiffel

            ),
            Monumentos(
                monumentoTitulo = R.string.NotreDame,
                monumentoInfo = R.string.InfoNotreDame,
                imageMonumento = R.drawable.dame,
                imageMonumento1 = R.drawable.dame1,
                imageMonumento2 = R.drawable.dame2,
                linkWikipedia = R.string.linkNotreDame,
                linkYoutube = R.string.youtubeNotreDame

            ),
            Monumentos(
                monumentoTitulo = R.string.Coliseo,
                monumentoInfo = R.string.InfoColiseo,
                imageMonumento = R.drawable.coliseo,
                imageMonumento1 = R.drawable.coliseo1,
                imageMonumento2 = R.drawable.coliseo2,
                linkWikipedia = R.string.Coliseo,
                linkYoutube = R.string.youtubeColiseo

            ),
            Monumentos(
                monumentoTitulo = R.string.PiramidesEgipto,
                monumentoInfo = R.string.InfoPiramidesEgipto,
                imageMonumento = R.drawable.piramide,
                imageMonumento1 = R.drawable.piramide1,
                imageMonumento2 = R.drawable.piramides2,
                linkWikipedia = R.string.linkPiramides,
                linkYoutube = R.string.youtubePiramides

            ),
            Monumentos(
                monumentoTitulo = R.string.OperaSidney,
                monumentoInfo = R.string.InfoOperaSidney,
                imageMonumento = R.drawable.sidney,
                imageMonumento1 = R.drawable.sidney1 ,
                imageMonumento2 = R.drawable.sidney2,
                linkWikipedia = R.string.linkOpera,
                linkYoutube = R.string.youtubeOpera

            ),
            Monumentos(
                monumentoTitulo = R.string.SagradaFamilia,
                monumentoInfo = R.string.InfoSagradaFamilia,
                imageMonumento = R.drawable.sagrada,
                imageMonumento1 = R.drawable.sagrada1,
                imageMonumento2 = R.drawable.sagrada2,
                linkWikipedia = R.string.linkSagradaFamilia,
                linkYoutube = R.string.youtubeSagradaFamilia

            ),
            Monumentos(
                monumentoTitulo = R.string.BigBen,
                monumentoInfo = R.string.InfoBigBen,
                imageMonumento = R.drawable.ben,
                imageMonumento1 = R.drawable.ben1,
                imageMonumento2 = R.drawable.ben2,
                linkWikipedia = R.string.linkBigBen,
                linkYoutube = R.string.youtubeBigBen
            ),
            Monumentos(
                monumentoTitulo = R.string.StonehengeInglaterra,
                monumentoInfo = R.string.InfoStonehengeInglaterra,
                imageMonumento = R.drawable.stonehedge,
                imageMonumento1 = R.drawable.stonehedge1,
                imageMonumento2 = R.drawable.stonehedge2,
                linkWikipedia = R.string.linkStonehedge,
                linkYoutube = R.string.youtubeStonehedge

            )
        )
    }



}