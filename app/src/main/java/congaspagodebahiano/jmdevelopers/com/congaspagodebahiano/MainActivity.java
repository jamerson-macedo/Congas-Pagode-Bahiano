package congaspagodebahiano.jmdevelopers.com.congaspagodebahiano;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends Activity  {
    private ImageView aguda;
    private ImageView media;
    private ImageView grave;
    private MediaPlayer mediaPlayer;
    private SoundPool playerCongaAguda;
    private SoundPool playerCongamedia;
    private SoundPool playerCongagrave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aguda = (ImageView) findViewById(R.id.congaAgudaID);
        media = (ImageView) findViewById(R.id.congamediaID);
        grave = (ImageView) findViewById(R.id.congagraveID);





        playerCongaAguda = new SoundPool.Builder().build();
        final int congaStreamId = playerCongaAguda.load(this,R.raw.conga1,1);
                //MediaPlayer.create(MainActivity.this,R.raw.conga1);
        playerCongamedia=new SoundPool.Builder().build();
        final int congamediaStreamId = playerCongamedia.load(this,R.raw.conga2,1);
        playerCongagrave=new SoundPool.Builder().build();
        final int congagraveStreamId = playerCongagrave.load(this,R.raw.conga3,1);

        aguda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerCongaAguda.resume(R.raw.conga1);
                playerCongaAguda.play(congaStreamId,1,1,0,0,1);
                //playerCongaAguda.seekTo(0);
                //playerCongaAguda.start();

            }
        });
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerCongamedia.play(congamediaStreamId,1,1,0,0,1);
            }
        });

        grave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerCongagrave.play(congagraveStreamId,1,1,0,0,1);
            }
        });





    }



    /*@Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.congaAgudaID:
                //mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.conga1);
                //tocarsom();
                //playerCongaAguda.seekTo(0);
                //playerCongaAguda.start();
                break;
            case  R.id.congamediaID:
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.conga2);
                tocarsom();
                break;
            case  R.id.congagraveID:
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.conga3);
                tocarsom();
                break;

        }

    }

    private void tocarsom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
*/
    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            //mediaPlayer.stop();
            mediaPlayer.release();
            //mediaPlayer=null;
        }
        super.onDestroy();
    }


}

