package com.handongwook.harry_potter.data.mapper

import com.handongwook.harry_potter.model.Wand
import com.handongwook.harry_potter.network.model.WandResponse

fun WandResponse.toDomain(): Wand {
    return Wand(
        wood = wood,
        core = core,
        length = length
    )
}