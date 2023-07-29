package com.dashingqi.generics
/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/7/29 14:34
 */


class XiaoMiTv1 : TV() {
    override fun turnOff() {
        super.turnOff()
    }

    override fun turnOn() {
        super.turnOn()
    }
}

class TvMi1SController {
    fun turnOn() {}
    fun turnOff() {}
}


class TvMi2SController {
    fun turnOn() {}
    fun turnOff() {}
}

class TvMi3SController {
    fun turnOn() {}
    fun turnOff() {}
}

class TvMi4SController {
    fun turnOn() {}
    fun turnOff() {}
}


open class Animal(val name: String) {}
class Dog(name: String) : Animal(name) {}
class Cat(name: String) : Animal(name) {}



