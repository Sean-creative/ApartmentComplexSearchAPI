package com.archisketch.apartmentcomplexsearchapi.service

import org.springframework.stereotype.Service

@Service
class CylinderService() {

    fun fetchCylinderData(): Map<String, Any>  {
        return mapOf(
            "name" to "[샘플] FLOOR COMPOSITION",
            "editorAsset" to "https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/2d/editor.png"
        )
    }
}