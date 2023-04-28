package com.x.compose


val date = listOf("乘用车", "奔驰金融服务", "大客户中心", "服务中心", "She's Mercedes", "在线服务预约", "原厂修养套餐")

fun main() {
    val calcList = mutableMapOf<Int, MutableList<String>>()
    var currentKey = 0
    date.forEachIndexed { index, s ->
        if (calcList[currentKey].isNullOrEmpty()) {
            calcList[currentKey] = mutableListOf(s)
        } else {
            val list = calcList[currentKey]
            if (list!!.totalSize() + s.length > 10) {
                currentKey++
                calcList[currentKey] = mutableListOf(s)
            } else {
                list.add(s)
            }
        }
    }
    println("listSub ${calcList}")
}

fun List<String>.totalSize(): Int {
    var width = 0
    forEach { item ->
        width += (item.length)
    }
    return width
}