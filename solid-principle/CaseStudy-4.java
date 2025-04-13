/*
Background: A media player handles different media types like audio and video files.
It has a MediaFile base class with common methods (play, pause, stop), while AudioFile and VideoFile subclasses
may have additional needs (e.g., subtitles for video). The player should be able to manage any file type seamlessly
without extra conditions.

Question: How would you structure the MediaFile, AudioFile, and VideoFile classes so the player works consistently with all file types?*/

class MediaFile {
    void play() {
        // PLAY
    }

    void pause() {
        // PAUSE
    }

    void stop() {
        // STOP
    }
}

class AudioFile extends MediaFile {

}

class VideoFile extends MediaFile {

    void showSubTitle() {
        // SHOW SUBTITLE
    }
}

class MediaPlayerService {
    void play(MediaFile file) {
        file.play();
    }

    void pause(MediaFile file) {
        file.pause();
    }

    void stop(MediaFile file) {
        file.stop();
    }
}