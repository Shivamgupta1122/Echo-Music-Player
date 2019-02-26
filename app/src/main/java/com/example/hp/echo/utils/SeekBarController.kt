package com.example.hp.echo.utils

import android.widget.SeekBar

import com.example.hp.echo.fragments.SongPlayingFragment

class SeekBarController : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        if (SongPlayingFragment.Statified.mediaplayer == null)
            return
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        if (p0?.progress!! < SongPlayingFragment.Statified.mediaplayer!!.duration) {
            SongPlayingFragment.Statified.mediaplayer!!.seekTo(p0?.progress!!)
        } else {
            SongPlayingFragment.Statified.mediaplayer?.seekTo((SongPlayingFragment.Statified.mediaplayer?.duration)!!.toInt())
        }
    }
}