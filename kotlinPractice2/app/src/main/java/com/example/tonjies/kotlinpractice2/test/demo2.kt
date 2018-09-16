package com.example.tonjies.kotlinpractice2.test

fun main(args: Array<String>) {
    //报错
    var student: Student? = null
    //加入以后，即使是空值调用方法也不会抛出空指针异常
//    student?.study()
    //加入以后，编译器就不会再帮我们处理空指针异常了
//    student!!.study()
    //加入之后，如果变量不为空，则执行变量的方法，如果变量为空，则执行右边的操作
    student?.study() ?: pritln()
    if(student==null){
        print("变量为空啦")
    }else{
        student.study()
    }
}
//声明在主函数之外
fun pritln() {
    println("变量为空")
}
