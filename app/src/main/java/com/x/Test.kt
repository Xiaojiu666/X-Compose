package com.x


fun main() {
    val createData = createData()
    println("createData ${createData.toString()}")
    val sortedWith = createData.sortedBy { it.name.uppercase() }
//    val sortedWith = createData.sortedWith(Comparator { t, t2 ->
//        t.name.compareTo(t2.name)
//    })
    println("createData ${sortedWith.toString()}")
}

fun createData(): List<UserInfo> {
    val users = mutableListOf<UserInfo>()
    users.add(UserInfo("c", 12))
    users.add(UserInfo("a", 1))
    users.add(UserInfo("z", 11))
    users.add(UserInfo("b", 11))
    users.add(UserInfo("y", 11))
    users.add(UserInfo("d", 13))
    users.add(UserInfo("f", 113))
    users.add(UserInfo("g", 11))
    users.add(UserInfo("x", 12))
    users.add(UserInfo("XinFang", 12))
    users.add(UserInfo("wangyuanchao", 12))
    users.add(UserInfo("a", 12))
    return users
}

data class UserInfo(val name: String, val age: Int)