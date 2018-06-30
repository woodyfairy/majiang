using UnityEngine;
using UnityEditor;
using UnityEditor.Callbacks;
using System.Collections;
//using cn.sharesdk.unity3d.sdkporter;
using System.IO;
using UnityEditor.XCodeEditor;

public static class ShareSDKPostProcessBuild {
	//[PostProcessBuild]
	[PostProcessBuildAttribute(88)]
	public static void onPostProcessBuild(BuildTarget target,string targetPath){
		string unityEditorAssetPath = Application.dataPath;

		if (target != BuildTarget.iOS) {
			Debug.LogWarning ("Target is not iPhone. XCodePostProcess will not run");
			string path = targetPath + "/" + PlayerSettings.productName;
			postProcessBuild_Android(path);
			return;
		}

		XCProject project = new XCProject (targetPath);
		//var files = System.IO.Directory.GetFiles( unityEditorAssetPath, "*.projmods", System.IO.SearchOption.AllDirectories );
		var files = System.IO.Directory.GetFiles( unityEditorAssetPath + "/Editor/SDKPorter", "*.projmods", System.IO.SearchOption.AllDirectories);
		foreach( var file in files ) {
			project.ApplyMod( file );
		}

		//如需要预配置Xocode中的URLScheme 和 白名单,请打开下两行代码,并自行配置相关键值
		string projPath = Path.GetFullPath (targetPath);
		EditInfoPlist (projPath);


		//Finally save the xcode project
		project.Save();

	}

	private static void EditInfoPlist(string projPath){

		XCPlist plist = new XCPlist (projPath);

		//URL Scheme 添加
		string PlistAdd = @"  
            <key>CFBundleURLTypes</key>
			<array>
				<dict>
					<key>CFBundleURLSchemes</key>
					<array>
					<string>wxfad8d17ff2dfe014</string>
					</array>
				</dict>
			</array>
            <key>NSMicrophoneUsageDescription</key>
            <string>1</string>";

		//白名单添加
		string LSAdd = @"
		<key>LSApplicationQueriesSchemes</key>
			<array>
			<string>wechat</string>
			<string>weixin</string>
		</array>";


		//在plist里面增加一行
		plist.AddKey(PlistAdd);
		plist.AddKey (LSAdd);
		plist.Save();
	}

	//安卓处理
	static private void postProcessBuild_Android(string path){
		//修改build.gradle
		UnityEditor.XCodeEditor.XClass buidGradle = new UnityEditor.XCodeEditor.XClass(path + "/build.gradle");
		buidGradle.Replace ("storePassword ''", "storePassword '123456'");
		buidGradle.Replace ("keyPassword ''", "keyPassword '123456'");
		buidGradle.WriteBelow("signingConfigs { release {", "storeFile file('/Users/wudongyang/Desktop/majiang/client/keystore/qingshui.keystore')\n\t\tstorePassword '123456'\n\t\tkeyAlias 'qingshui'\n\t\tkeyPassword '123456'\n\t}\n\tdebug{");
		buidGradle.WriteBelow ("\t\tclasspath 'com.android.tools.build:gradle:2.1.0'", "\t\tclasspath 'com.mob.sdk:MobSDK:+'");
		buidGradle.WriteBelow ("apply plugin: 'com.android.application'", "// 添加插件\napply plugin: 'com.mob.sdk'\n\n// 在MobSDK的扩展中注册PaySDK的相关信息\nMobSDK {\n\tappKey \"2324aeba579a0\"\n\tappSecret \"39388cda43b2e7f37ff706210da4f78f\"\n\n\tPaySDK {}\n}");


		//修改AndroidManifest
		UnityEditor.XCodeEditor.XClass manifest = new UnityEditor.XCodeEditor.XClass(path + "/src/main/AndroidManifest.xml");
		manifest.WriteBelow("<uses-permission android:name=\"android.permission.INTERNET\" />", 
			"    <uses-permission android:name=\"android.permission.GET_TASKS\" />\n"+
			"    <uses-permission android:name=\"android.permission.INTERNET\" />\n"+
			"    <uses-permission android:name=\"android.permission.ACCESS_WIFI_STATE\" />\n"+
			"    <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n"+
			"    <uses-permission android:name=\"android.permission.CHANGE_WIFI_STATE\" />\n"+
			"    <uses-permission android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\" />\n"+
			"    <uses-permission android:name=\"android.permission.READ_PHONE_STATE\" />\n"+
			"    <uses-permission android:name=\"android.permission.MANAGE_ACCOUNTS\"/>\n"+
			"    <uses-permission android:name=\"android.permission.GET_ACCOUNTS\"/>\n"+
			"    <uses-permission android:name=\"android.permission.RECEIVE_SMS\" />\n"+
			"    <!-- 蓝牙分享所需的权限 -->\n"+
			"    <uses-permission android:name=\"android.permission.BLUETOOTH\" />\n"+
			"    <uses-permission android:name=\"android.permission.BLUETOOTH_ADMIN\" />");
		manifest.WriteAbove ("</application>", "<activity\n            android:name=\"com.mob.tools.MobUIShell\"\n            android:configChanges=\"keyboardHidden|orientation|screenSize\"\n            android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n            android:windowSoftInputMode=\"stateHidden|adjustResize\" >\n       \n\t\t \t<!-- 新浪回调 -->\n            <intent-filter>\n\t\t\t\t<action android:name=\"com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY\" />\n\t\t\t\t\t\t<category android:name=\"android.intent.category.DEFAULT\" />\n\t\t\t\t</intent-filter>\n\t\t\t\t <!-- 集成Line客户端登录授权，需要添加如下格式的过滤器 -->\n            <intent-filter android:priority=\"1000\">\n               <action android:name=\"android.intent.action.VIEW\" />\n               <category android:name=\"android.intent.category.DEFAULT\" />\n               <category android:name=\"android.intent.category.BROWSABLE\" />\n  \t\t\t\t\t\t <data android:scheme=\"line.1477692153\" />\n            </intent-filter>\t\n        </activity>\n\n        <!--\n            如果集成QQ分享，或者使用QQ客户端来进行QQ空间的分享，须要在此处添加一个回调activity，\n            对ACTION_VIEW事件的过滤器，其中的scheme是“tencent”前缀再开发者应用的加上appId。如\n            果此过滤器不设置，则分享结束以后不能得到正确的回调\n        -->\n        <activity\n            android:name=\"cn.sharesdk.tencent.qq.ReceiveActivity\"\n            android:launchMode=\"singleTask\"\n            android:noHistory=\"true\">\n            <intent-filter>\n                <action android:name=\"android.intent.action.VIEW\" />\n                <category android:name=\"android.intent.category.DEFAULT\" />\n                <category android:name=\"android.intent.category.BROWSABLE\" />\n                <data android:scheme=\"tencent100371282\" />\n            </intent-filter>\n        </activity>\n\n        <!-- 微信分享回调 -->\n        <activity\n            android:name=\".wxapi.WXEntryActivity\"\n            android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n            android:configChanges=\"keyboardHidden|orientation|screenSize\"\n            android:exported=\"true\" />\n        <!-- 易信分享回调 -->\n        <activity\n            android:name=\".yxapi.YXEntryActivity\"\n            android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n            android:configChanges=\"keyboardHidden|orientation|screenSize\"\n            android:excludeFromRecents=\"true\"\n            android:exported=\"true\"\n            android:launchMode=\"singleTop\" />\t\t\t\n        <!-- 支付宝分享回调 -->\n        <activity\n            android:name=\".apshare.ShareEntryActivity\"\n            android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n            android:configChanges=\"keyboardHidden|orientation|screenSize\"\n            android:exported=\"true\"/>\n\n        <meta-data android:name=\"Mob-AppKey\" android:value=\"2324aeba579a0\"/>\n        <meta-data android:name=\"Mob-AppSecret\" android:value=\"39388cda43b2e7f37ff706210da4f78f\"/>");

		//修改proguard-unity.txt
		UnityEditor.XCodeEditor.XClass proguard = new UnityEditor.XCodeEditor.XClass(path + "/proguard-unity.txt");
		proguard.WriteBelow("-keep class org.fmod.* { *; }", "-keep class com.mob.**{*;}\n-dontwarn com.mob.**");

		//拷贝文件
		string sdkAndroidProject = Application.dataPath.Replace("Assets", "SdkAndroidProject");
		DirectoryCopy(sdkAndroidProject , path + "/src/main/java/com/gsqsjh/qsmj");
	}
	#region 拷贝文件到目标文件夹
	public static void DirectoryCopy(string sourceDirName, string destDirName)
	{
		try
		{
			DirectoryInfo dir = new DirectoryInfo(sourceDirName);
			DirectoryInfo[] dirs = dir.GetDirectories();

			if (!dir.Exists)
			{
				return;
			}

			if (!Directory.Exists(destDirName))
			{
				Directory.CreateDirectory(destDirName);
			}

			FileInfo[] files = dir.GetFiles();

			foreach (FileInfo file in files)
			{
				string temppath = Path.Combine(destDirName, file.Name);
				file.CopyTo(temppath, true);
			}

			foreach (DirectoryInfo subdir in dirs)
			{
				string temppath = Path.Combine(destDirName, subdir.Name);
				DirectoryCopy(subdir.FullName, temppath);
			}
		}
		catch (System.Exception ex)
		{
			Debug.LogError("DirectoryCopy.ex:" + ex.ToString());
		}
	}
	#endregion
}