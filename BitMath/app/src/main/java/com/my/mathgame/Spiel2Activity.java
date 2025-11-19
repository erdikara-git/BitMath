package com.my.mathgame;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class Spiel2Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String backgroundColor = "";
	private double WelcherIstRichtig = 0;
	private double PlusOderMinus = 0;
	private double PlusOderMinus2 = 0;
	private double PlusOderMinus3 = 0;
	
	private LinearLayout linear1;
	private TextView textview6;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private TextView textview5;
	private LinearLayout linear2;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview7;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview8;
	private TextView textview9;
	private TextView textview10;
	private TextView textview11;
	
	private SharedPreferences high;
	private SharedPreferences score;
	private Intent intent = new Intent();
	private SharedPreferences languages;
	private TimerTask timer;
	private SharedPreferences ergebnis;
	private SharedPreferences mode;
	private TimerTask timer2;
	private TimerTask timer3;
	private SharedPreferences random;
	private SharedPreferences modusart;
	private SharedPreferences coins;
	private RequestNetwork Network;
	private RequestNetwork.RequestListener _Network_request_listener;
	private SharedPreferences mainads;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.spiel2);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		textview6 = findViewById(R.id.textview6);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear5 = findViewById(R.id.linear5);
		textview5 = findViewById(R.id.textview5);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview7 = findViewById(R.id.textview7);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		high = getSharedPreferences("scores", Activity.MODE_PRIVATE);
		score = getSharedPreferences("best", Activity.MODE_PRIVATE);
		languages = getSharedPreferences("languages", Activity.MODE_PRIVATE);
		ergebnis = getSharedPreferences("ergebnis", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		random = getSharedPreferences("random", Activity.MODE_PRIVATE);
		modusart = getSharedPreferences("modusart", Activity.MODE_PRIVATE);
		coins = getSharedPreferences("coins", Activity.MODE_PRIVATE);
		Network = new RequestNetwork(this);
		mainads = getSharedPreferences("mainads", Activity.MODE_PRIVATE);
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Antwort(textview8);
			}
		});
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Antwort(textview9);
			}
		});
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Antwort(textview10);
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Antwort(textview11);
			}
		});
		
		_Network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		high.edit().putString("scores2", "0").commit();
		textview5.setVisibility(View.VISIBLE);
		linear2.setVisibility(View.INVISIBLE);
		linear5.setVisibility(View.INVISIBLE);
		textview6.setVisibility(View.INVISIBLE);
		textview5.setText("3");
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview5.setText("2");
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										textview5.setText("1");
										timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														linear2.setVisibility(View.VISIBLE);
														linear5.setVisibility(View.VISIBLE);
														textview5.setVisibility(View.GONE);
														textview6.setVisibility(View.VISIBLE);
														_timers();
														_aufgaben();
													}
												});
											}
										};
										_timer.schedule(timer, (int)(1000));
									}
								});
							}
						};
						_timer.schedule(timer, (int)(1000));
					}
				});
			}
		};
		_timer.schedule(timer, (int)(1000));
		_style();
	}
	
	@Override
	public void onBackPressed() {
		timer3 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						timer2.cancel();
					}
				});
			}
		};
		_timer.schedule(timer3, (int)(4500));
		finish();
	}
	public void _timers() {
		textview6.setText("60");
		timer2 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview6.setText(String.valueOf((long)(Double.parseDouble(textview6.getText().toString()) - 1)));
						if (Double.parseDouble(textview6.getText().toString()) == 0) {
							if (SketchwareUtil.isConnected(getApplicationContext())) {
								if (Double.parseDouble(score.getString("best2", "")) < Double.parseDouble(high.getString("scores2", ""))) {
									score.edit().putString("best2", high.getString("scores2", "")).commit();
								}
								if (languages.getString("language", "").equals("english")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores2", "").concat(" points reached"));
								}
								if (languages.getString("language", "").equals("deutsch")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores2", "").concat(" Punkte erreicht"));
								}
								if (languages.getString("language", "").equals("türkçe")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores2", "").concat(" puan ulaşıldı"));
								}
								_coin();
								timer2.cancel();
								mainads.edit().putString("mainads", "1").commit();
								finish();
							}
							else {
								if (Double.parseDouble(score.getString("best2", "")) < Double.parseDouble(high.getString("scores2", ""))) {
									score.edit().putString("best2", high.getString("scores2", "")).commit();
								}
								if (languages.getString("language", "").equals("english")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores2", "").concat(" points reached"));
								}
								if (languages.getString("language", "").equals("deutsch")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores2", "").concat(" Punkte erreicht"));
								}
								if (languages.getString("language", "").equals("türkçe")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores2", "").concat(" puan ulaşıldı"));
								}
								if (languages.getString("language", "").equals("english")) {
									SketchwareUtil.showMessage(getApplicationContext(), "error 500: Internet connection failed\nScore counted but coins were not credited");
								}
								if (languages.getString("language", "").equals("deutsch")) {
									SketchwareUtil.showMessage(getApplicationContext(), "error 500: Internet verbindung fehlgeschlagen\nScore gezählt, aber Münzen wurden nicht gutgeschrieben");
								}
								if (languages.getString("language", "").equals("türkçe")) {
									SketchwareUtil.showMessage(getApplicationContext(), "error 500: Internet bağlantısı kurulamadı\nPuan sayıldı ama coinler hesaba katılmadı");
								}
								timer2.cancel();
								intent.setAction(Intent.ACTION_VIEW);
								intent.setClass(getApplicationContext(), MainActivity.class);
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(intent);
								finish();
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer2, (int)(1000), (int)(1000));
	}
	
	
	public void _aufgaben() {
		random.edit().putString("zahl2", String.valueOf((long)(SketchwareUtil.getRandom((int)(1), (int)(3))))).commit();
		if (Double.parseDouble(random.getString("zahl2", "")) == 1) {
			textview2.setText("+");
			if (modusart.getString("Modus", "").equals("Normal")) {
				textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(99)))));
				textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(99)))));
			}
			else {
				if (modusart.getString("Modus", "").equals("Hart")) {
					textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(999)))));
					textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(999)))));
				}
				else {
					if (modusart.getString("Modus", "").equals("Extrem")) {
						textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9999)))));
						textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9999)))));
					}
				}
			}
			ergebnis.edit().putString("ergebnis2", String.valueOf((long)(Double.parseDouble(textview1.getText().toString()) + Double.parseDouble(textview3.getText().toString())))).commit();
		}
		else {
			if (Double.parseDouble(random.getString("zahl2", "")) == 2) {
				textview2.setText("-");
				if (modusart.getString("Modus", "").equals("Normal")) {
					textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(99)))));
					textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(99)))));
				}
				else {
					if (modusart.getString("Modus", "").equals("Hart")) {
						textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(999)))));
						textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(999)))));
					}
					else {
						if (modusart.getString("Modus", "").equals("Extrem")) {
							textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9999)))));
							textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9999)))));
						}
					}
				}
				ergebnis.edit().putString("ergebnis2", String.valueOf((long)(Double.parseDouble(textview1.getText().toString()) - Double.parseDouble(textview3.getText().toString())))).commit();
			}
			else {
				if (Double.parseDouble(random.getString("zahl2", "")) == 3) {
					textview2.setText("×");
					if (modusart.getString("Modus", "").equals("Normal")) {
						textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
						textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
					}
					else {
						if (modusart.getString("Modus", "").equals("Hart")) {
							textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(99)))));
							textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(10)))));
						}
						else {
							if (modusart.getString("Modus", "").equals("Extrem")) {
								textview1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(999)))));
								textview3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(10)))));
							}
						}
					}
					ergebnis.edit().putString("ergebnis2", String.valueOf((long)(Double.parseDouble(textview1.getText().toString()) * Double.parseDouble(textview3.getText().toString())))).commit();
				}
			}
		}
		_ergebnisse();
	}
	
	
	public void _roundedAndRipple(final View _view, final String _backgroundColor, final String _rippleColor, final double _radius) {
		//Code from StackOverflow and adapted for Sketchware by @BOFA 
		//Please do not reupload. If you want to improve, feel free just give credit.
		
		//For colors include #
		
		if (_backgroundColor.equals("")) {
			//If you leave the background color empty, it will be set to this default color.
			backgroundColor = "#FFFFFF";
		}
		else {
			backgroundColor = _backgroundColor;
		}
		android.content.res.ColorStateList pressedStates = android.content.res.ColorStateList.valueOf(Color.parseColor(_rippleColor)); 
		//adapted for Sketchware by BOFA
		android.graphics.drawable.GradientDrawable contentDrawable = new android.graphics.drawable.GradientDrawable();
		contentDrawable.setColor(Color.parseColor(backgroundColor));
		if (!(_radius == 0)) {
			//If you leave radius empty, no radius will be added.
			contentDrawable.setCornerRadius((int)_radius);
		}
		android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(pressedStates, contentDrawable, null);
		//
		_view.setBackground(rippleDrawable);
	}
	
	
	public void _style() {
		if (mode.getString("mode", "").equals("dark")) {
			_roundedAndRipple(textview8, "#424242", "#9E9E9E", 45);
			_roundedAndRipple(textview9, "#424242", "#9E9E9E", 45);
			_roundedAndRipple(textview10, "#424242", "#9E9E9E", 45);
			_roundedAndRipple(textview11, "#424242", "#9E9E9E", 45);
			linear1.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
			textview7.setTextColor(0xFFFFFFFF);
		}
		if (mode.getString("mode", "").equals("light")) {
			_roundedAndRipple(textview8, "#000000", "#FFFFFF", 45);
			_roundedAndRipple(textview9, "#000000", "#FFFFFF", 45);
			_roundedAndRipple(textview10, "#000000", "#FFFFFF", 45);
			_roundedAndRipple(textview11, "#000000", "#FFFFFF", 45);
			linear1.setBackgroundColor(0xFFFFFFFF);
			textview1.setTextColor(0xFF000000);
			textview2.setTextColor(0xFF000000);
			textview3.setTextColor(0xFF000000);
			textview4.setTextColor(0xFF000000);
			textview7.setTextColor(0xFF000000);
		}
	}
	
	
	public void _ergebnisse() {
		WelcherIstRichtig = SketchwareUtil.getRandom((int)(1), (int)(4));
		PlusOderMinus = SketchwareUtil.getRandom((int)(1), (int)(2));
		PlusOderMinus2 = SketchwareUtil.getRandom((int)(1), (int)(2));
		PlusOderMinus3 = SketchwareUtil.getRandom((int)(1), (int)(2));
		if (WelcherIstRichtig == 1) {
			textview8.setText(ergebnis.getString("ergebnis2", ""));
			if (PlusOderMinus == 1) {
				textview9.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus == 2) {
				textview9.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 1) {
				textview10.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 2) {
				textview10.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 1) {
				textview11.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 2) {
				textview11.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
		}
		if (WelcherIstRichtig == 2) {
			textview9.setText(ergebnis.getString("ergebnis2", ""));
			if (PlusOderMinus == 1) {
				textview8.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus == 2) {
				textview8.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 1) {
				textview10.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 2) {
				textview10.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 1) {
				textview11.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 2) {
				textview11.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
		}
		if (WelcherIstRichtig == 3) {
			textview10.setText(ergebnis.getString("ergebnis2", ""));
			if (PlusOderMinus == 1) {
				textview8.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus == 2) {
				textview8.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 1) {
				textview9.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 2) {
				textview9.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 1) {
				textview11.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 2) {
				textview11.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
		}
		if (WelcherIstRichtig == 4) {
			textview11.setText(ergebnis.getString("ergebnis2", ""));
			if (PlusOderMinus == 1) {
				textview8.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus == 2) {
				textview8.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 1) {
				textview9.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus2 == 2) {
				textview9.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 1) {
				textview10.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
			if (PlusOderMinus3 == 2) {
				textview10.setText(String.valueOf((long)(Double.parseDouble(ergebnis.getString("ergebnis2", "")) - SketchwareUtil.getRandom((int)(1), (int)(20)))));
			}
		}
	}
	
	
	public void _Antwort(final TextView _textview) {
		if (_textview.getText().toString().equals(ergebnis.getString("ergebnis2", ""))) {
			high.edit().putString("scores2", String.valueOf((long)(Double.parseDouble(high.getString("scores2", "")) + 1))).commit();
			ergebnis.edit().putString("ergebnis2", "").commit();
			_aufgaben();
			_roundedAndRipple(_textview, "#81C784", "#FFFFFF", 45);
			timer3 = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_style();
						}
					});
				}
			};
			_timer.schedule(timer3, (int)(100));
		}
		else {
			high.edit().putString("scores2", String.valueOf((long)(Double.parseDouble(high.getString("scores2", "")) - 1))).commit();
			ergebnis.edit().putString("ergebnis2", "").commit();
			_aufgaben();
			_roundedAndRipple(_textview, "#E57373", "#FFFFFF", 45);
			timer3 = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_style();
						}
					});
				}
			};
			_timer.schedule(timer3, (int)(100));
		}
	}
	
	
	public void _coin() {
		if (high.getString("scores2", "").contains("+") || high.getString("scores2", "").contains("")) {
			if (modusart.getString("Modus", "").equals("Normal")) {
				coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) + (Double.parseDouble(high.getString("scores2", "")) * 1)))).commit();
			}
			else {
				if (modusart.getString("Modus", "").equals("Hart")) {
					coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) + (Double.parseDouble(high.getString("scores2", "")) * 2)))).commit();
				}
				else {
					if (modusart.getString("Modus", "").equals("Extrem")) {
						coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) + (Double.parseDouble(high.getString("scores2", "")) * 3)))).commit();
					}
				}
			}
		}
		if (high.getString("scores2", "").contains("-")) {
			if (modusart.getString("Modus", "").equals("Normal")) {
				coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) - (Double.parseDouble(high.getString("scores2", "")) * 1)))).commit();
			}
			else {
				if (modusart.getString("Modus", "").equals("Hart")) {
					coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) - (Double.parseDouble(high.getString("scores2", "")) * 2)))).commit();
				}
				else {
					if (modusart.getString("Modus", "").equals("Extrem")) {
						coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) - (Double.parseDouble(high.getString("scores2", "")) * 3)))).commit();
					}
				}
			}
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}