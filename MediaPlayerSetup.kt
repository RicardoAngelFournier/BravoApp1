
private var mediaPlayer: MediaPlayer? = null 

override fun onCreate(savedInstanceState: Bundle?) {
  
  ... Other stuff to initalize
  
  setupMediaPlayer()
  startMediaPlayer()
}

override fun onResume() {
  super.onResume()
  startMediaPlayer()
}

override fun onPause() {
  super.onPause()
  stopMediaPlayer()
}

private fun setupMediaPlayer() {
  mediaPlayer = MediaPlayer.create(this, R.raw.htmlthesong)
  mediaPlayer?.isLooping = true       // CICLO DE MUSICA
}

private fun startMediaPlayer() {
  mediaPlayer?.isPlaying?.let { 
                                      //Ejecutar SI mediaPlayer NO ES null
    if(!it)
      mediaPlayer?.start()
  } ?: run { 
                                     // Ejecutar si es null
    setupMediaPlayer()
    startMediaPlayer()
  }
}

private fun stopMediaPlayer() {
  mediaPlayer?.isPlaying?.let {
    if(it)
      mediaPlayer?.stop()
      
    mediaPlayer?.release()
    mediaPlayer = null
  }
}
