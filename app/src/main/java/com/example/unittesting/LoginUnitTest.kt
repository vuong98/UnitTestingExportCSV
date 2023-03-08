package com.example.unittesting

import android.text.TextUtils
import android.util.Patterns

class LoginUnitTest {

    fun checkLogin(userName : String , passWord : String  ) : Boolean {

        if (userName.equals("Admin@gmail.com") == true && passWord.equals("vuong.1300") == true ) {
            return true
        }
        return false
    }
    fun checkEmailValidator(strEmail : String ) :Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        if(strEmail.length > 0 && strEmail.matches(emailRegex.toRegex()) ) {
            return true
        }
        return false ;
    }
    fun checkLengthPassWord(strPass : String )  :Boolean {
        if (strPass.length >= 8 ) return true
        return false
    }
}