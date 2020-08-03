package com.omaressam.rode

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage


class IntroActivity : AppIntro() {

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        doneWithIntro()
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        doneWithIntro()
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showIntroSlides()

    }

    private fun showIntroSlides() {
        val sliderPage1 = SliderPage()
        sliderPage1.title = " Choose Your Field "
       sliderPage1.description = "Different careers , you can choose your own"
        sliderPage1.bgColor = R.color.blue
         sliderPage1.imageDrawable = R.drawable.intro1
        addSlide(AppIntroFragment.newInstance(sliderPage1))
        //

        val sliderPage2 = SliderPage()
        sliderPage2.title = "Get Your Roadmap"
       sliderPage2.description = "Provide your career path by updated roadmaps"
        sliderPage2.bgColor = R.color.blue
        sliderPage2.imageDrawable = R.drawable.intro2
        addSlide(AppIntroFragment.newInstance(sliderPage2))
        //
        val sliderPage3 = SliderPage()
        sliderPage3.title = "Courses For Your Field"
       sliderPage3.description = "Finding a suitable courses for your career"
        sliderPage3.bgColor = R.color.blue
        sliderPage3.imageDrawable = R.drawable.intro3

        addSlide(AppIntroFragment.newInstance(sliderPage3))


    }

    private fun doneWithIntro()
    {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("intro,keeplogin" , Context.MODE_PRIVATE )

        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putBoolean("first time" , false)
        //for keep me login
        editor.putBoolean("keep me" , false)
        editor.putString("mail" , null)
        editor.putString("pass" , null)
        editor.apply()
        editor.commit()
    }


}