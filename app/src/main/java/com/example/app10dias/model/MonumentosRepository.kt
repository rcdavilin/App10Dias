package com.example.app10dias.model

import com.example.app10dias.R

object MonumentosRepository {
    val monumentos = listOf(

        Monumentos(
            monumentoTitulo = R.string.Taj_Mahal,
            monumentoInfo = R.string.InfoTaj_Mahal,
            imageMonumento = R.drawable.taj_mahal
        ),
        Monumentos(
            monumentoTitulo = R.string.MurallaChina,
            monumentoInfo = R.string.InfoMurallaChina,
            imageMonumento = R.drawable.murallachina
        ),
        Monumentos(
            monumentoTitulo = R.string.TorreEiffel,
            monumentoInfo = R.string.InfoTorreEiffel,
            imageMonumento = R.drawable.torreeiffel
            ),
        Monumentos(
            monumentoTitulo = R.string.NotreDame,
            monumentoInfo = R.string.InfoNotreDame,
            imageMonumento = R.drawable.notredame
        ),
        Monumentos(
            monumentoTitulo = R.string.Coliseo,
            monumentoInfo = R.string.InfoColiseo,
            imageMonumento = R.drawable.coliseo
        ),
        Monumentos(
            monumentoTitulo = R.string.PiramidesEgipto,
            monumentoInfo = R.string.InfoPiramidesEgipto,
            imageMonumento = R.drawable.piramidesegipto
        ),
        Monumentos(
            monumentoTitulo = R.string.OperaSidney,
            monumentoInfo = R.string.InfoOperaSidney,
            imageMonumento = R.drawable.operasideny
        ),
        Monumentos(
            monumentoTitulo = R.string.SagradaFamilia,
            monumentoInfo = R.string.InfoSagradaFamilia,
            imageMonumento = R.drawable.sagradafamilia
        ),
        Monumentos(
            monumentoTitulo = R.string.BigBen,
            monumentoInfo = R.string.InfoBigBen,
            imageMonumento = R.drawable.bigben
        ),
        Monumentos(
            monumentoTitulo = R.string.StonehengeInglaterra,
            monumentoInfo = R.string.InfoStonehengeInglaterra,
            imageMonumento = R.drawable.stonehenge
        )
    )
}