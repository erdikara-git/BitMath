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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
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

public class SpielActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private TextView textview6;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview5;
	private LinearLayout linear2;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private EditText edittext1;
	
	private TimerTask timer;
	private TimerTask timer2;
	private SharedPreferences high;
	private SharedPreferences random;
	private SharedPreferences ergebnis;
	private SharedPreferences score;
	private Intent intent = new Intent();
	private SharedPreferences modusart;
	private TimerTask timer3;
	private SharedPreferences languages;
	private SharedPreferences mode;
	private SharedPreferences coins;
	private RequestNetwork Network;
	private RequestNetwork.RequestListener _Network_request_listener;
	private SharedPreferences mainads;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.spiel);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		textview6 = findViewById(R.id.textview6);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		textview5 = findViewById(R.id.textview5);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		edittext1 = findViewById(R.id.edittext1);
		high = getSharedPreferences("scores", Activity.MODE_PRIVATE);
		random = getSharedPreferences("random", Activity.MODE_PRIVATE);
		ergebnis = getSharedPreferences("ergebnis", Activity.MODE_PRIVATE);
		score = getSharedPreferences("best", Activity.MODE_PRIVATE);
		modusart = getSharedPreferences("modusart", Activity.MODE_PRIVATE);
		languages = getSharedPreferences("languages", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		coins = getSharedPreferences("coins", Activity.MODE_PRIVATE);
		Network = new RequestNetwork(this);
		mainads = getSharedPreferences("mainads", Activity.MODE_PRIVATE);
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals(ergebnis.getString("ergebnis", ""))) {
					high.edit().putString("scores", String.valueOf((long)(Double.parseDouble(high.getString("scores", "")) + 1))).commit();
					edittext1.setText("");
					ergebnis.edit().putString("ergebnis", "").commit();
					final Toast toast = Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT); toast.show(); Handler handler = new Handler(); handler.postDelayed(new Runnable() { @Override public void run() { toast.cancel(); } }, 800);
					_aufgaben();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
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
		high.edit().putString("scores", "0").commit();
		linear2.setVisibility(View.INVISIBLE);
		textview5.setVisibility(View.VISIBLE);
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
		final EditText edittext = (EditText) findViewById(R.id.edittext1); edittext.setOnKeyListener(new View.OnKeyListener() { public boolean onKey(View v, int keyCode, KeyEvent event) { if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) { 
					_edittext();
					 return true; } return false; } });
		edittext1.requestFocus();
		_theme();
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
								if (Double.parseDouble(score.getString("best", "")) < Double.parseDouble(high.getString("scores", ""))) {
									score.edit().putString("best", high.getString("scores", "")).commit();
								}
								if (languages.getString("language", "").equals("english")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores", "").concat(" points reached"));
								}
								if (languages.getString("language", "").equals("deutsch")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores", "").concat(" Punkte erreicht"));
								}
								if (languages.getString("language", "").equals("türkçe")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores", "").concat(" puan ulaşıldı"));
								}
								_coin();
								timer2.cancel();
								mainads.edit().putString("mainads", "1").commit();
								finish();
							}
							else {
								if (Double.parseDouble(score.getString("best", "")) < Double.parseDouble(high.getString("scores", ""))) {
									score.edit().putString("best", high.getString("scores", "")).commit();
								}
								if (languages.getString("language", "").equals("english")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores", "").concat(" points reached"));
								}
								if (languages.getString("language", "").equals("deutsch")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores", "").concat(" Punkte erreicht"));
								}
								if (languages.getString("language", "").equals("türkçe")) {
									SketchwareUtil.showMessage(getApplicationContext(), high.getString("scores", "").concat(" puan ulaşıldı"));
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
		random.edit().putString("zahl", String.valueOf((long)(SketchwareUtil.getRandom((int)(1), (int)(3))))).commit();
		if (Double.parseDouble(random.getString("zahl", "")) == 1) {
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
			ergebnis.edit().putString("ergebnis", String.valueOf((long)(Double.parseDouble(textview1.getText().toString()) + Double.parseDouble(textview3.getText().toString())))).commit();
		}
		else {
			if (Double.parseDouble(random.getString("zahl", "")) == 2) {
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
				ergebnis.edit().putString("ergebnis", String.valueOf((long)(Double.parseDouble(textview1.getText().toString()) - Double.parseDouble(textview3.getText().toString())))).commit();
			}
			else {
				if (Double.parseDouble(random.getString("zahl", "")) == 3) {
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
					ergebnis.edit().putString("ergebnis", String.valueOf((long)(Double.parseDouble(textview1.getText().toString()) * Double.parseDouble(textview3.getText().toString())))).commit();
				}
			}
		}
	}
	
	
	public void _edittext() {
		if (edittext1.getText().toString().equals(ergebnis.getString("ergebnis", ""))) {
			high.edit().putString("scores", String.valueOf((long)(Double.parseDouble(high.getString("scores", "")) + 1))).commit();
			edittext1.setText("");
			ergebnis.edit().putString("ergebnis", "").commit();
			final Toast toast = Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT); toast.show(); Handler handler = new Handler(); handler.postDelayed(new Runnable() { @Override public void run() { toast.cancel(); } }, 800);
			_aufgaben();
		}
		else {
			high.edit().putString("scores", String.valueOf((long)(Double.parseDouble(high.getString("scores", "")) - 1))).commit();
			edittext1.setText("");
			ergebnis.edit().putString("ergebnis", "").commit();
			final Toast toast = Toast.makeText(getApplicationContext(), "-1", Toast.LENGTH_SHORT); toast.show(); Handler handler = new Handler(); handler.postDelayed(new Runnable() { @Override public void run() { toast.cancel(); } }, 800);
			_aufgaben();
		}
	}
	
	
	public void _theme() {
		if (mode.getString("mode", "").equals("dark")) {
			linear1.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFFFFFFFF);
		}
		if (mode.getString("mode", "").equals("light")) {
			linear1.setBackgroundColor(0xFFFFFFFF);
			textview1.setTextColor(0xFF000000);
			textview2.setTextColor(0xFF000000);
			textview3.setTextColor(0xFF000000);
			textview4.setTextColor(0xFF000000);
			edittext1.setTextColor(0xFF000000);
		}
		edittext1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c) { this.setStroke(a, b); this.setColor(c); return this; } }.getIns((int)3, 0x20BDBDBD, Color.TRANSPARENT));
	}
	
	
	public void _coin() {
		if (high.getString("scores", "").contains("+") || high.getString("scores", "").contains("")) {
			if (modusart.getString("Modus", "").equals("Normal")) {
				coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) + (Double.parseDouble(high.getString("scores", "")) * 1)))).commit();
			}
			else {
				if (modusart.getString("Modus", "").equals("Hart")) {
					coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) + (Double.parseDouble(high.getString("scores", "")) * 2)))).commit();
				}
				else {
					if (modusart.getString("Modus", "").equals("Extrem")) {
						coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) + (Double.parseDouble(high.getString("scores", "")) * 3)))).commit();
					}
				}
			}
		}
		if (high.getString("scores", "").contains("-")) {
			if (modusart.getString("Modus", "").equals("Normal")) {
				coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) - (Double.parseDouble(high.getString("scores", "")) * 1)))).commit();
			}
			else {
				if (modusart.getString("Modus", "").equals("Hart")) {
					coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) - (Double.parseDouble(high.getString("scores", "")) * 2)))).commit();
				}
				else {
					if (modusart.getString("Modus", "").equals("Extrem")) {
						coins.edit().putString("coins", String.valueOf((long)(Double.parseDouble(coins.getString("coins", "")) - (Double.parseDouble(high.getString("scores", "")) * 3)))).commit();
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