package com.handongwook.harry_potter.core.data.mapper

import com.handongwook.harry_potter.core.model.Wand
import com.handongwook.harry_potter.core.network.model.WandResponse

fun WandResponse.toDomain(): Wand {
    return Wand(
        wood = wood,
        core = core,
        length = length
    )
}