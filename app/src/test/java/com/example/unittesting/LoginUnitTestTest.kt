package com.example.unittesting

import android.util.Log
import org.json.JSONArray
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.FileWriter
import java.io.IOException


class LoginUnitTestTest {
    lateinit var writer: FileWriter

    @Before
    fun setUp() {
        // Initialize the CSV writer object
        writer = FileWriter("result.csv",true)
        System.out.println("Before")
    }

    @After
    fun tearDown() {
        // Close the CSV writer object after all the test functions are executed
        writer.close()
        System.out.println("After")
    }
    @Test
    fun checkLogin() {
        System.out.println("checkLogin")
        try {
            val json =  javaClass.classLoader?.getResourceAsStream("test.json")
            val text = json?.bufferedReader().use {
                it?.readText()
            }
            val jsonInput = JSONArray(text)

           // val writer = FileWriter("result.csv")
            writer.append("LoginUnitTestTest, checkLogin() \n")
            for(i in 0 .. jsonInput.length() - 1 step 1){
                val jsonObjectInput = jsonInput.getJSONObject(i)

                val resultInput = jsonObjectInput.getBoolean("output")
                val nameTestCase = jsonObjectInput.getString("name")
                val account = jsonObjectInput.getJSONObject("input")
                val username = account.getString("username")
                val password = account.getString("password")

                val resultFunction = LoginUnitTest().checkLogin(username, password)
                writer.append("+,"+nameTestCase+","+resultFunction+"\n")
                Assert.assertEquals(resultInput, resultFunction)
            }
        }catch (e : IOException) {

        }

    }

    @Test
    fun checkEmailValidator() {

        System.out.println("checkEmailValidator")

        val json =  javaClass.classLoader?.getResourceAsStream("test.json")
        val text = json?.bufferedReader().use {
            it?.readText()
        }
        val jsonInput = JSONArray(text)

        //val writer = FileWriter("result.csv")
        writer.append("LoginUnitTestTest, checkEmailValidator() \n")
        for(i in 0 .. jsonInput.length() - 1 step 1){
            val jsonObjectInput = jsonInput.getJSONObject(i)

            val resultInput : Boolean? = jsonObjectInput.getBoolean("output")
            val nameTestCase = jsonObjectInput.getString("name")
            val account = jsonObjectInput.getJSONObject("input")
            val username : String?= account.getString("username")
            //System.out.println("$resultInput    - $username" )

            val resultFunction = LoginUnitTest().checkEmailValidator(username!!)
            writer.append("+,"+nameTestCase+","+resultFunction+"\n")
            Assert.assertEquals(resultInput, resultFunction)
        }
    }

    @Test
    fun checkLengthPassWord() {

        System.out.println("checkLengthPassWord")

        val json =  javaClass.classLoader?.getResourceAsStream("test.json")
        val text = json?.bufferedReader().use {
            it?.readText()
        }
        val jsonInput = JSONArray(text)

       // val writer = FileWriter("result.csv")
        writer.append("LoginUnitTestTest, checkLengthPassWord() \n")
        for(i in 0 .. jsonInput.length() - 1 step 1){
            val jsonObjectInput = jsonInput.getJSONObject(i)

            val resultInput = jsonObjectInput.getBoolean("output")
            val nameTestCase = jsonObjectInput.getString("name")
            val account = jsonObjectInput.getJSONObject("input")
            val username = account.getString("username")
            val password = account.getString("password")

            val resultFunction = LoginUnitTest().checkLengthPassWord(password)
            writer.append("+,"+nameTestCase+","+resultFunction+"\n")

            Assert.assertEquals(resultInput, resultFunction)
        }
       // writer.close()
    }
}