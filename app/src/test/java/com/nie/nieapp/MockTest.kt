package com.nie.nieapp

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when`


/**
 * 说明：
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */
class MockTest {
    @Mock
    lateinit var mockedList: MutableList<String>

    @Test
    fun testMock() {
        MockitoAnnotations.initMocks(this)
        //使用Mock对象
        mockedList.add("one")
        mockedList.clear()

        //验证函数的调用次数
//        verify(mockedList).add("one")
//        verify(mockedList).add("two")//无此操作，验证 failed
//        verify(mockedList).clear()


        //测试桩，在调用get(0)时返回"first"
        `when`(mockedList[0]).thenReturn("first")
//调用get(1)时抛出异常
        `when`(mockedList[1]).thenThrow(RuntimeException())

////输出first
//        System.out.println(mockedList[0])
//抛出异常
        System.out.println(mockedList[1])
////因为get(999)没有打桩，因此输出null
//        System.out.println(mockedList[999])
    }
}