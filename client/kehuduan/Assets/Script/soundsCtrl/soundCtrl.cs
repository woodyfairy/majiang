using UnityEngine;
using System.Collections;
/**
 * sound control class
 * 
 * author :kevin
 * 
 * */
public class SoundCtrl  {

	private Hashtable soudHash = new Hashtable (); 

	private static SoundCtrl _instance;

	private static AudioSource audioS;
    private static AudioSource audioBGM;

    public static SoundCtrl getInstance(){
		if (_instance == null) {
			_instance = new SoundCtrl ();
			audioS = GameObject.Find ("MyAudio").GetComponent<AudioSource> ();
            audioS.volume = PlayerPrefs.GetFloat("audioYinXiao", 1);
            audioBGM = GameObject.Find("BGMAudio").GetComponent<AudioSource>();
            audioBGM.volume = PlayerPrefs.GetFloat("audioEffect", 1);
        }

		return _instance;
	}

    public void ChangeVolume(float vol)
    {
        audioS.volume = vol;
    }
    public void ChangeBGMVolume(float vol)
    {
        audioBGM.volume = vol;
    }

    public void playSound(int cardPoint,int sex){
		if (GlobalDataScript.soundToggle) {
			string path = "Sounds/";
			if (sex == 1) {
                path += "boy" + PlayerPrefs.GetString("AudioType", "") + "/" + (cardPoint + 1);
			} else {
                path += "girl" + PlayerPrefs.GetString("AudioType", "") + "/" + (cardPoint + 1);
			}
			AudioClip temp = (AudioClip)soudHash [path];
			if (temp == null) {
				temp = GameObject.Instantiate (Resources.Load (path)) as AudioClip;
				soudHash.Add (path, temp);
			}
			audioS.clip = temp;
			audioS.loop = false;
			audioS.Play ();
		}
	}

    public void playMessageBoxSound(int codeIndex, int sex = -1){
		if(GlobalDataScript.soundToggle){
			string path = "Sounds/other/";
            if(sex == -1)
            {
                path += codeIndex;
            }
            else if (sex == 1)
            {
                path += "boy" + PlayerPrefs.GetString("AudioType", "") + "/" + codeIndex;
            }
            else
            {
                path += "women" + PlayerPrefs.GetString("AudioType", "") + "/" + codeIndex;
            }
			AudioClip temp = (AudioClip)soudHash[path];
			if(temp == null){
				temp = GameObject.Instantiate(Resources.Load (path)) as AudioClip;
				soudHash.Add (path,temp);
			}
			audioS.clip = temp;
            audioS.loop = false;
            audioS.Play ();
		}
	}

	public void playBGM(int type){
		string path = "Sounds/mjBGM";
        if (type == 0)
        {
            path = "Sounds/mjBGM";
        }
        else if (type == 1)
        {
            path = "Sounds/mjBGM_inGame";
        }
		AudioClip temp = (AudioClip)soudHash[path];
		if(temp == null){
			temp = GameObject.Instantiate(Resources.Load (path)) as AudioClip;
			soudHash.Add (path,temp);
		}
        audioBGM.clip = temp;
        audioBGM.loop = true;
        audioBGM.Play ();
		if (GlobalDataScript.soundToggle) {
            audioBGM.mute = false;
		} else {
            audioBGM.mute = true;
		}
	}

	public void stopBGM(){
        audioBGM.loop = false;
        audioBGM.Stop ();
	}

	public void playSoundByAction(string str,int sex){
		string path = "Sounds/";
		if (sex == 1) {
            path += "boy" + PlayerPrefs.GetString("AudioType", "") + "/" + str;
		} else {
            path += "girl" + PlayerPrefs.GetString("AudioType", "") + "/" + str;
		}
		AudioClip temp = (AudioClip)soudHash[path];
		if(temp == null){
			temp = GameObject.Instantiate(Resources.Load (path)) as AudioClip;
			soudHash.Add (path,temp);
		}
		audioS.clip = temp;
        audioS.loop = false;
        audioS.Play ();
	}

    public void playSoundEffect(string str)
    {
        if (GlobalDataScript.soundToggle)
        {
            string path = "Sounds/Effect/" + str;
            Debug.Log("play:" + path);
            AudioClip temp = (AudioClip)soudHash[path];
            if (temp == null)
            {
                temp = GameObject.Instantiate(Resources.Load(path)) as AudioClip;
                soudHash.Add(path, temp);
            }
            audioS.clip = temp;
            audioS.loop = false;
            audioS.Play();
        }
    }
}
