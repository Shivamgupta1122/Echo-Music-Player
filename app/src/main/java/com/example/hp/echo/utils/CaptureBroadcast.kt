package com.example.hp.echo.utils

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.text.style.TtsSpan
import com.example.hp.echo.R
import com.example.hp.echo.activities.MainActivity
import com.example.hp.echo.fragments.SongPlayingFragment
import internshala.com.echomusik.R

class CaptureBroadcast : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1?.action == Intent.ACTION_NEW_OUTGOING_CALL){
            try {
                MainActivity.Statified.notificationManager?.cancel(1978)
            }
            catch (e : Exception)
            {
                e.printStackTrace()
            }
            try {
                if(SongPlayingFragment.Statified.mediaplayer?.isPlaying as Boolean){
                    SongPlayingFragment.Statified.mediaplayer?.pause()
                    SongPlayingFragment.Statified.playpauseImageButton?.setBackgroundResource(R.drawable.play_icon)
                }
            }
            catch (e : Exception)
            {
                e.printStackTrace()
            }
        }
        else{
            val tm : TelephonyManager = p0?.getSystemService(Service.TELEPHONY_SERVICE) as TelephonyManager
            when(tm?.callState){
                TelephonyManager.CALL_STATE_RINGING ->{
                    try {
                        MainActivity.Statified.notificationManager?.cancel(1978)
                    }
                    catch (e : Exception)
                    {
                        e.printStackTrace()
                    }
                    try {
                        if(SongPlayingFragment.Statified.mediaplayer?.isPlaying as Boolean){
                            SongPlayingFragment.Statified.mediaplayer?.pause()
                            SongPlayingFragment.Statified.playpauseImageButton?.setBackgroundResource(R.drawable.play_icon)
                        }
                    }
                    catch (e : Exception)
                    {
                        e.printStackTrace()
                    }
                }
                else ->{

                }
            }
        }
    }

}