package com.raman.mylibrary

import android.content.Context
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
/*
This library stores count of activity accessed and in Shared Preferences ( or Sqlite )

How to use it
apply this code to all Activities of onCreate lifecycle call

    override fun onCreate(savedInstanceState: Bundle?) {

            .....

            // when Activity starts it reports in onCreate method that it has been accessed
            ScreenChanges.report(this)
        }

 */

class ScreenChanges {
    companion object {

        // user of this library will call this function and pass context so that it can keep and count
        // use in onCreate of activity only
        fun report( context : Context){
            val className = context.javaClass.name
            incrementCount(className, context)
        }

        // this private function take className and store a count value in storage and then report to a api
        private fun incrementCount(className : String , context : Context) {
            val sp: SharedPreferences = context.getSharedPreferences("thisActivityCount", MODE_PRIVATE)
            val editor = sp.edit()
            editor.putInt(className, 1 + sp.getInt(className, 0))
            editor.commit()

            // TODO we can put some condition when to report
            reportToApi(className, sp.getInt(className, 0) , "reportToApi.com/report")
        }

        // this function is used for reporting activity count to an api [used by function incrementCount]
        private fun reportToApi(className: String, count : Int , url: String) {

        }


    }
}