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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class PayoutActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String backgroundColor = "";
	private String email = "";
	private String coinamount = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String randomstring = "";
	private String randomstring2 = "";
	private String randomstring3 = "";
	private String randomstring4 = "";
	private String randomstring5 = "";
	private String endstring = "";
	private double randomnumber = 0;
	private double randomnumber2 = 0;
	private double randomnumber3 = 0;
	private double randomnumber4 = 0;
	private double randomnumber5 = 0;
	private String htmltext2 = "";
	private String htmltext = "";
	private String coinbaselink = "";
	
	private LinearLayout linear1;
	private ImageView imageview2;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private LinearLayout linear9;
	private TextView textview4;
	private EditText edittext1;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private TextView textview5;
	private Button button1;
	private TextView textview2;
	private ImageView imageview1;
	private AdView adview1;
	
	private SharedPreferences coins;
	private SharedPreferences mode;
	private SharedPreferences languages;
	private Intent intent = new Intent();
	private RequestNetwork res;
	private RequestNetwork.RequestListener _res_request_listener;
	private DatabaseReference payout = _firebase.getReference("payout");
	private ChildEventListener _payout_child_listener;
	private Intent coinbaseintent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.payout);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview2 = findViewById(R.id.imageview2);
		linear12 = findViewById(R.id.linear12);
		linear11 = findViewById(R.id.linear11);
		linear9 = findViewById(R.id.linear9);
		textview4 = findViewById(R.id.textview4);
		edittext1 = findViewById(R.id.edittext1);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox2 = findViewById(R.id.checkbox2);
		textview5 = findViewById(R.id.textview5);
		button1 = findViewById(R.id.button1);
		textview2 = findViewById(R.id.textview2);
		imageview1 = findViewById(R.id.imageview1);
		adview1 = findViewById(R.id.adview1);
		coins = getSharedPreferences("coins", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		languages = getSharedPreferences("languages", Activity.MODE_PRIVATE);
		res = new RequestNetwork(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		checkbox1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (languages.getString("language", "").equals("english")) {
					htmltext2 = "<h1>Terms of Service</h1>\n<p>&nbsp;</p>\n<p>Last updated: November 10, 2021</p>\n<p>&nbsp;</p>\n<p><strong>We know terms and conditions are boring and the majority try to avoid them</strong>, however, we ask you to read these general terms and conditions carefully before using our services.</p>\n<p>&nbsp;</p>\n<h2>Interpretation &amp; Definitions</h2>\n<p><strong>&nbsp;</strong></p>\n<p>The words whose first letter is capitalized have defined meanings under the following conditions. The following definitions have the same meaning regardless of whether they appear in the singular or plural.</p>\n<p>&nbsp;</p>\n<p>For the purposes of these terms and conditions:</p>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Terms and Conditions</strong> refer to these general terms and conditions</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Coin / Coins </strong>refer to the points earned in the application, which can then be redeemed.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Services</strong> refers to the BitMath application</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>country</strong> refers to Germany</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>You / you </strong>refers to the person accessing or using the Service, or a company or other legal entity on whose behalf that person is accessing or using the Services, if applicable</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Companies </strong>refers to BitMath, also \"The Company\", \"We\" or \"Our\"</li>\n</ul>\n<p>&nbsp;</p>\n<h2>Privacy policy</h2>\n<p><strong>&nbsp;</strong></p>\n<p>The protection of your data is very important to us. We do not save any of your data except for the e-mail address given during a \"payout\" and the amount of coins at the relevant moment. This data will be permanently deleted within one week (6 working days) after the withdrawal has been made and cannot be restored by anyone.</p>\n<p>&nbsp;</p>\n<h2>Payouts</h2>\n<p><strong>&nbsp;</strong></p>\n<p>Withdrawals of coins are only possible from an amount of 1,000 (one thousand). Withdrawals are made in random cryptocurrencies. The &ldquo;Coinbase&rdquo; platform (owner: Coinbase, Inc.) is used for withdrawals. For a smooth payout, you also need a deposit on the platform mentioned. Payouts are made within one week (6 working days) if possible. Losses caused by incorrectly entering the email address or by not owning a Coinbase depot cannot be technically canceled and thus cannot be reversed. If manipulation of the amount of coins is suspected, all payouts are stopped and checked for correctness. In the event of manipulation, legal channels are initiated. We strive to make withdrawals however, are not obliged to offer and / or pay out withdrawals. We reserve the right not to make withdrawals and not to transfer the respective number of cryptocurrencies to the email address mentioned.</p>\n<p><strong>&nbsp;</strong></p>\n<h2>copyright</h2>\n<p><strong>&nbsp;</strong></p>\n<p>&copy; Copyright 2021 - Copyright Notice</p>\n<p>&nbsp;</p>\n<p>All contents of the BitMath application, in particular the logo, texts and graphics, are protected by copyright. Unless expressly stated otherwise, the copyright lies with Erdi Karasungur. Please ask us if you would like to use the content of this website.</p>\n<p>&nbsp;</p>\n<p>Anyone who violates copyright law (e.g. unauthorized copying of graphics or texts) is liable to prosecution according to &sect;&sect; 106 ff UrhG, is also warned against costs and has to pay compensation (&sect; 97 UrhG).</p>\n<p><strong>&nbsp;</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Errors and omissions excepted.</p>";
				}
				if (languages.getString("language", "").equals("deutsch")) {
					htmltext2 = "<p><h1>Allgemeine Gesch&auml;ftsbedingungen</h1></p>\n<p>&nbsp;</p>\n<p>Zuletzt aktualisiert: November 10, 2021</p>\n<p>&nbsp;</p>\n<p><strong>Wir wissen das Allgemeine Gesch&auml;ftsbedingungen langweilig sind und der Gro&szlig;teil versucht diese zu meiden</strong>, jedoch bitten wir Sie diese Allgemeinen Gesch&auml;ftsbedingungen bevor Sie unsere Dienstleistungen nutzen sorgf&auml;ltig zu lesen.</p>\n<p>&nbsp;</p>\n<p><h2>Interpretation &amp; Definitionen</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>Die W&ouml;rter, deren Anfangsbuchstabe gro&szlig;geschrieben wird, haben unter den folgenden Bedingungen definierte Bedeutungen. Die folgenden Definitionen haben die gleiche Bedeutung, unabh&auml;ngig davon, ob sie im Singular oder Plural vorkommen.</p>\n<p>&nbsp;</p>\n<p>F&uuml;r die Zwecke dieser Allgemeinen Gesch&auml;ftsbedingungen:</p>\n<p>&nbsp;</p>\n<ul>\n<li><strong>AGB/AGB&rsquo;s</strong> beziehen sich auf diese Allgemeinen Gesch&auml;ftsbedingungen</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Coin/Coins </strong>beziehen sich auf die in der Applikation verdienten Punkte, welche im Anschluss eingel&ouml;st werden k&ouml;nnen.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Dienstleistungen</strong> bezieht sich auf die Applikation BitMath</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Land</strong> bezieht sich auf Deutschland</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Sie/Ihnen </strong>bezieht sich auf die Person, welche auf die Dienstleistung zugreift oder diese nutzt, oder ein Unternehmen oder eine andere juristische Person, in deren Namen diese Person auf die Dienstleistungen zugreift oder diese nutzt, falls zutreffend</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Unternehmen </strong>bezieht sich auf BitMath, auch ,,Das Unternehmen&ldquo;, ,,Wir&ldquo; oder ,,Unser&ldquo;</li>\n</ul>\n<p>&nbsp;</p>\n<p><h2>Datenschutz</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>Der Schutz Ihrer Daten stellt f&uuml;r uns eine sehr hohe Wichtigkeit dar. Wir speichern keine Daten von Ihnen au&szlig;er die bei einer ,,Auszahlung&ldquo; genannten E-Mail Adresse sowie die Menge der Coins in dem entsprechenden Moment. Diese Daten werden innerhalb von einer Woche (6 Werktagen), nachdem die Auszahlung durchgef&uuml;hrt wurde, endg&uuml;ltig gel&ouml;scht und k&ouml;nnen von keinem wiederhergestellt werden.</p>\n<p>&nbsp;</p>\n<p><h2>Auszahlungen</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>Auszahlungen von Coins sind erst ab einer Menge von 1.000 (eintausend) m&ouml;glich. Die Auszahlungen werden in zuf&auml;lligen Kryptow&auml;hrungen durchgef&uuml;hrt. F&uuml;r die Auszahlungen wird die Plattform ,,Coinbase&ldquo; (Eigent&uuml;mer: Coinbase, Inc.) verwendet. F&uuml;r eine reibungslose Auszahlung ben&ouml;tigen Sie ebenfalls ein Depot auf der genannten Plattform. Auszahlungen werden, wenn m&ouml;glich, innerhalb einer Woche (6 Werktagen) ausgezahlt. Verluste welche durch falsche Eingabe der Email-Adresse oder durch nicht besitzen eines Coinbase Depots entstanden sind, k&ouml;nnen technisch <strong>nicht</strong> Storniert und somit <strong>nicht</strong> r&uuml;ckg&auml;ngig gemacht werden. Beim verdacht von Manipulation der Coin-Menge werden alle Auszahlungen gestoppt und auf Richtigkeit kontrolliert. Bei Manipulationen werden Rechtliche Wege eingeleitet. Wir bem&uuml;hen uns Auszahlungen durchzuf&uuml;hren, sind jedoch <strong>nicht verpflichtet</strong> Auszahlungen anzubieten und/oder diese Auszuzahlen. <strong>Wir behalten uns das Recht vor, Auszahlungen nicht durchzuf&uuml;hren und die jeweilige Anzahl an Kryptow&auml;hrungen nicht an die genannte Email-Adresse zu transferieren.</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p><h2>Copyright</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>&copy; Copyright 2021 &ndash; Urheberrechtshinweis</p>\n<p>&nbsp;</p>\n<p>Alle Inhalte der BitMath Applikation, insbesondere das Logo, Texte und Grafiken, sind urheberrechtlich gesch&uuml;tzt. Das Urheberrecht liegt, soweit nicht ausdr&uuml;cklich anders gekennzeichnet, bei Erdi Karasungur. Bitte fragen Sie uns, falls Sie die Inhalte dieses Internetangebotes verwenden m&ouml;chten.</p>\n<p>&nbsp;</p>\n<p>Wer gegen das Urheberrecht verst&ouml;&szlig;t (z.B. Grafiken oder Texte unerlaubt kopiert), macht sich gem. &sect;&sect; 106 ff UrhG strafbar, wird zudem kostenpflichtig abgemahnt und muss Schadensersatz leisten (&sect; 97 UrhG).</p>\n<p><strong>&nbsp;</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Fehler und Irrt&uuml;mer vorbehalten.</p>";
				}
				if (languages.getString("language", "").equals("türkçe")) {
					htmltext2 = "<h1>Kullanım Şartları</h1>\n<p>&nbsp;</p>\n<p>Son g&uuml;ncelleme: 10 Kasım 2021</p>\n<p>&nbsp;</p>\n<p><strong>Şartlar ve koşulların sıkıcı olduğunu biliyoruz ve &ccedil;oğunluk bunlardan ka&ccedil;ınmaya &ccedil;alışıyor</strong>Ancak, hizmetlerimizi kullanmadan &ouml;nce bu genel h&uuml;k&uuml;m ve koşulları dikkatlice okumanızı rica ediyoruz.</p>\n<p>&nbsp;</p>\n<h2>Yorum ve Tanımlar</h2>\n<p><strong>&nbsp;</strong></p>\n<p>İlk harfi b&uuml;y&uuml;k olan kelimeler aşağıdaki koşullar altında tanımlanmış anlamlara sahiptir. Aşağıdaki tanımlar, tekil veya &ccedil;oğul olarak g&ouml;r&uuml;n&uuml;p g&ouml;r&uuml;nmediklerine bakılmaksızın aynı anlama sahiptir.</p>\n<p>&nbsp;</p>\n<p>Bu h&uuml;k&uuml;m ve koşulların ama&ccedil;ları doğrultusunda:</p>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Şartlar ve koşullar</strong> bu genel h&uuml;k&uuml;m ve koşullara bakın</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Madeni Para / Madeni Para </strong>Uygulamada kazanılan ve daha sonra kullanılabilecek puanlara bakın.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Hizmetler</strong> BitMath uygulamasını ifade eder</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>&uuml;lke</strong> Almanya'yı ifade eder</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>sen / sen </strong>Hizmete erişen veya onu kullanan kişiyi veya varsa, bu kişinin adına Hizmetlere eriştiği veya onu kullandığı bir şirket veya başka bir t&uuml;zel kişilik anlamına gelir.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Şirketler </strong>BitMath, ayrıca \"Şirket\", \"Biz\" veya \"Bizim\" anlamına gelir.</li>\n</ul>\n<p>&nbsp;</p>\n<h2>Veri koruması</h2>\n<p><strong>&nbsp;</strong></p>\n<p>Verilerinizin korunması bizim i&ccedil;in &ccedil;ok &ouml;nemlidir.Bir \"&ouml;deme\" sırasında verilen e-posta adresi ve ilgili andaki jeton miktarı dışında hi&ccedil;bir verinizi kaydetmiyoruz. Bu veriler, para &ccedil;ekme işlemi yapıldıktan sonra bir hafta (6 iş g&uuml;n&uuml;) i&ccedil;inde kalıcı olarak silinecek ve kimse tarafından geri alınamayacak.</p>\n<p>&nbsp;</p>\n<h2>&Ouml;demeler</h2>\n<p><strong>&nbsp;</strong></p>\n<p>Madeni paraların &ccedil;ekilmesi yalnızca 1.000 (bin) miktarından m&uuml;mk&uuml;nd&uuml;r. Para &ccedil;ekme işlemleri rastgele kripto para birimlerinde yapılır. Para &ccedil;ekme işlemleri i&ccedil;in &ldquo;Coinbase&rdquo; platformu (sahibi: Coinbase, Inc.) kullanılır. Sorunsuz bir &ouml;deme i&ccedil;in, belirtilen platformda depozitoya ihtiyacınız var. Para &ccedil;ekme işlemi m&uuml;mk&uuml;nse bir hafta (6 iş g&uuml;n&uuml;) i&ccedil;inde yapılacaktır. E-posta adresinin yanlış girilmesinden veya bir Coinbase deposuna sahip olunmamasından kaynaklanan kayıplar teknik olarak iptal edilemez ve bu nedenle geri alınamaz. Madeni para miktarının manip&uuml;lasyonundan ş&uuml;pheleniliyorsa, t&uuml;m &ouml;demeler durdurulur ve doğruluğu kontrol edilir. Manip&uuml;lasyon durumunda yasal işlem yapılır. Para &ccedil;ekme i&ccedil;in &ccedil;alışıyoruz ancak, &ouml;deme teklif etmek ve/veya &ouml;demek zorunda değildir. Belirtilen e-posta adresine ilgili sayıda kripto para &ccedil;ekmeme ve transfer etmeme hakkımız saklıdır.</p>\n<p><strong>&nbsp;</strong></p>\n<h2>Telif hakkı</h2>\n<p><strong>&nbsp;</strong></p>\n<p>&copy; Copyright 2021 - Telif Hakkı Bildirimi</p>\n<p>&nbsp;</p>\n<p>BitMath uygulamasının t&uuml;m i&ccedil;eriği, &ouml;zellikle logo, metinler ve grafikler telif hakkı ile korunmaktadır. Aksi a&ccedil;ık&ccedil;a belirtilmedik&ccedil;e telif hakkı Erdi Karasungur'a aittir. Bu web sitesinin i&ccedil;eriğini kullanmak isteyip istemediğinizi l&uuml;tfen bize sorun.</p>\n<p>&nbsp;</p>\n<p>Telif hakkı yasasını ihlal eden (&ouml;rneğin grafiklerin veya metinlerin izinsiz kopyalanması) herhangi bir kişi &sect;&sect; 106 ff UrhG uyarınca kovuşturmaya tabidir, ayrıca masraflara karşı uyarılır ve tazminat &ouml;demek zorundadır (&sect; 97 UrhG).</p>\n<p><strong>&nbsp;</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Hatalar ve eksiklikler hari&ccedil;tir.</p>";
				}
				final AlertDialog db4 = new AlertDialog.Builder(PayoutActivity.this).create();
								LayoutInflater inflater = getLayoutInflater();
				View convertView = (View) inflater.inflate(R.layout.impressum, null);
				db4.setView(convertView);
				db4.requestWindowFeature(Window.FEATURE_NO_TITLE);  
				db4.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
				
				TextView textview2 = (TextView) convertView.findViewById(R.id.textview2);
				
				TextView textview3 = (TextView) convertView.findViewById(R.id.textview3);
				
				ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
				
				ScrollView vscroll1 = (ScrollView) convertView.findViewById(R.id.vscroll1);
				
				vscroll1.setSmoothScrollingEnabled(true);
				
				textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
				
				textview3.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
				
				if (mode.getString("mode", "").equals("dark")) {
						textview2.setTextColor(0xFFFFFFFF);
					
					textview3.setTextColor(0xFFFFFFFF);
					
					_Shape(30, 30, 30, 30, "#424242", 0, "#fbc02d", 0, linear1);
						imageview1.setImageResource(R.drawable.ic_clear_white);
				}
				if (mode.getString("mode", "").equals("light")) {
						textview2.setTextColor(0xFF000000);
					
					textview3.setTextColor(0xFF000000);
					
					_Shape(30, 30, 30, 30, "#ffffff", 0, "#fbc02d", 0, linear1);
						imageview1.setImageResource(R.drawable.ic_close_black);
				}
				
				textview2.setVisibility(View.GONE);
				
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview2.setText(Html.fromHtml(htmltext, Html.FROM_HTML_MODE_COMPACT)); } else { textview2.setText(Html.fromHtml(htmltext)); }
				
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview3.setText(Html.fromHtml(htmltext2, Html.FROM_HTML_MODE_COMPACT)); } else { textview3.setText(Html.fromHtml(htmltext2)); }
				
				db4.setCancelable(true);
				imageview1.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
												db4.dismiss();
									}
						});
				
				db4.show();
			}
		});
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				coinbaseintent.setAction(Intent.ACTION_VIEW);
				coinbaseintent.setData(Uri.parse("https://www.coinbase.com/join/karasu_jv?src=android-link"));
				coinbaseintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(coinbaseintent);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext1.getText().toString().contains(" @".replace(" ", "")) || (5 > edittext1.getText().toString().length())) {
					if (languages.getString("language", "").equals("english")) {
						((EditText)edittext1).setError("Please enter more than 5 letters and the @ Symbol");
					}
					if (languages.getString("language", "").equals("deutsch")) {
						((EditText)edittext1).setError("Bitte geben Sie mehr als fünf Zeichen ein und das @ Symbol");
					}
					if (languages.getString("language", "").equals("türkçe")) {
						((EditText)edittext1).setError("Lütfen beşten fazla karakter ve @ sembolü girin");
					}
				}
				else {
					if (!checkbox1.isChecked()) {
						if (languages.getString("language", "").equals("english")) {
							((EditText)edittext1).setError("Please accept the terms");
						}
						if (languages.getString("language", "").equals("deutsch")) {
							((EditText)edittext1).setError("Bitte akzeptieren Sie die Bedingungen");
						}
						if (languages.getString("language", "").equals("türkçe")) {
							((EditText)edittext1).setError("Lütfen koşulları onaylayınız");
						}
					}
					else {
						if (!checkbox1.isChecked()) {
							if (languages.getString("language", "").equals("english")) {
								((EditText)edittext1).setError("Please accept that you have an Coinbase depot");
							}
							if (languages.getString("language", "").equals("deutsch")) {
								((EditText)edittext1).setError("Bitte akzeptieren Sie das Sie ein Depot bei Coinbase haben");
							}
							if (languages.getString("language", "").equals("türkçe")) {
								((EditText)edittext1).setError("Lütfen Coinbasede deponuz olduğunu onaylayınız");
							}
						}
						else {
							if (Double.parseDouble(coins.getString("coins", "")) < 1000) {
								if (languages.getString("language", "").equals("english")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Not enough coins");
								}
								if (languages.getString("language", "").equals("deutsch")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Nicht genügend coins vorhanden");
								}
								if (languages.getString("language", "").equals("türkçe")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Yeterince coin yok");
								}
							}
							else {
								if (SketchwareUtil.isConnected(getApplicationContext())) {
									_coin();
									coins.edit().putString("coins", "0").commit();
									if (languages.getString("language", "").equals("english")) {
										SketchwareUtil.showMessage(getApplicationContext(), button1.getText().toString().concat(" successfull"));
									}
									if (languages.getString("language", "").equals("deutsch")) {
										SketchwareUtil.showMessage(getApplicationContext(), button1.getText().toString().concat(" erfolgreich"));
									}
									if (languages.getString("language", "").equals("türkçe")) {
										SketchwareUtil.showMessage(getApplicationContext(), button1.getText().toString().concat(" başarılı"));
									}
									map.put("Email", edittext1.getText().toString());
									map.put("CoinAmount", textview2.getText().toString());
									_random2();
									payout.child(payout.push().getKey()).updateChildren(map);
								}
								else {
									if (languages.getString("language", "").equals("english")) {
										SketchwareUtil.showMessage(getApplicationContext(), "error 500: Internet connection failed\nScore counted but coins were not credited");
									}
									if (languages.getString("language", "").equals("deutsch")) {
										SketchwareUtil.showMessage(getApplicationContext(), "error 500: Internet verbindung fehlgeschlagen\nScore gezählt, aber Münzen wurden nicht gutgeschrieben");
									}
									if (languages.getString("language", "").equals("türkçe")) {
										SketchwareUtil.showMessage(getApplicationContext(), "error 500: Internet bağlantısı kurulamadı\nPuan sayıldı ama coinler hesaba katılmadı");
									}
								}
							}
						}
					}
				}
			}
		});
		
		_res_request_listener = new RequestNetwork.RequestListener() {
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
		
		_payout_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		payout.addChildEventListener(_payout_child_listener);
	}
	
	private void initializeLogic() {
		_coin();
		_style();
		_language();
		_ads();
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (adview1 != null) {
			adview1.destroy();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (adview1 != null) {
			adview1.pause();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (adview1 != null) {
			adview1.resume();
		}
	}
	public void _coin() {
		textview2.setText(coins.getString("coins", ""));
		textview4.setText("~ ".concat(new DecimalFormat("0.00000000000").format(Double.parseDouble(textview2.getText().toString()) / 783591000).concat(" BTC")));
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
			_roundedAndRipple(button1, "#424242", "#9E9E9E", 45);
			linear1.setBackgroundColor(0xFF212121);
			edittext1.setHintTextColor(0xFF9E9E9E);
			edittext1.setTextColor(0xFFFFFFFF);
			checkbox1.setTextColor(0xFFFFFFFF);
			checkbox2.setTextColor(0xFFFFFFFF);
			imageview2.setImageResource(R.drawable.ic_arrow_back_white);
		}
		if (mode.getString("mode", "").equals("light")) {
			_roundedAndRipple(button1, "#000000", "#FFFFFF", 45);
			linear1.setBackgroundColor(0xFFFFFFFF);
			edittext1.setHintTextColor(0xFFE0E0E0);
			edittext1.setTextColor(0xFF000000);
			checkbox1.setTextColor(0xFF000000);
			checkbox2.setTextColor(0xFF000000);
			imageview2.setImageResource(R.drawable.ic_arrow_back_black);
		}
	}
	
	
	public void _language() {
		if (languages.getString("language", "").equals("english")) {
			button1.setText("Pay out");
			edittext1.setHint("Enter Wallet Email-Adress");
			checkbox1.setText("Accept the Terms");
			checkbox2.setText("I have an Coinbase Depot");
			coinbaselink = "<p style=\"color:#009DFF\";><u>Set up a depot at coinbase</u></p>";
		}
		if (languages.getString("language", "").equals("deutsch")) {
			button1.setText("Auszahlen");
			edittext1.setHint("Wallet Email-Adresse eingeben");
			checkbox1.setText("Bin mit den Bedingungen einverstanden");
			checkbox2.setText("Ich habe ein Depot bei Coinbase");
			coinbaselink = "<p style=\"color:#009DFF\";><u>\nBei Coinbase registrieren</u></p>";
		}
		if (languages.getString("language", "").equals("türkçe")) {
			button1.setText("Parayı çek");
			edittext1.setHint("Wallet Email-Adresinizi giriniz");
			checkbox1.setText("Koşulları kabul ediyorum");
			checkbox2.setText("Coinbasede benim depom var");
			coinbaselink = "<p style=\"color:#009DFF\";><u>\nCoinbase'de bir depo kurun</u></p>";
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview5.setText(Html.fromHtml(coinbaselink, Html.FROM_HTML_MODE_COMPACT)); } else { textview5.setText(Html.fromHtml(coinbaselink)); }
	}
	
	
	public void _ads() {
		adview1.loadAd(new AdRequest.Builder().build());
	}
	
	
	public void _random2() {
		randomnumber = SketchwareUtil.getRandom((int)(1), (int)(62));
		if (randomnumber == 1) {
				randomstring = "a";
		}
		if (randomnumber == 2) {
				randomstring = "A";
		}
		if (randomnumber == 3) {
				randomstring = "b";
		}
		if (randomnumber == 4) {
				randomstring = "B";
		}
		if (randomnumber == 5) {
				randomstring = "c";
		}
		if (randomnumber == 6) {
				randomstring = "C";
		}
		if (randomnumber == 7) {
				randomstring = "d";
		}
		if (randomnumber == 8) {
				randomstring = "D";
		}
		if (randomnumber == 9) {
				randomstring = "e";
		}
		if (randomnumber == 10) {
				randomstring = "E";
		}
		if (randomnumber == 11) {
				randomstring = "f";
		}
		if (randomnumber == 12) {
				randomstring = "F";
		}
		if (randomnumber == 13) {
				randomstring = "g";
		}
		if (randomnumber == 14) {
				randomstring = "G";
		}
		if (randomnumber == 15) {
				randomstring = "h";
		}
		if (randomnumber == 16) {
				randomstring = "H";
		}
		if (randomnumber == 17) {
				randomstring = "i";
		}
		if (randomnumber == 18) {
				randomstring = "I";
		}
		if (randomnumber == 19) {
				randomstring = "j";
		}
		if (randomnumber == 20) {
				randomstring = "J";
		}
		if (randomnumber == 21) {
				randomstring = "k";
		}
		if (randomnumber == 22) {
				randomstring = "K";
		}
		if (randomnumber == 23) {
				randomstring = "l";
		}
		if (randomnumber == 24) {
				randomstring = "L";
		}
		if (randomnumber == 25) {
				randomstring = "m";
		}
		if (randomnumber == 26) {
				randomstring = "M";
		}
		if (randomnumber == 27) {
				randomstring = "n";
		}
		if (randomnumber == 28) {
				randomstring = "N";
		}
		if (randomnumber == 29) {
				randomstring = "o";
		}
		if (randomnumber == 30) {
				randomstring = "O";
		}
		if (randomnumber == 31) {
				randomstring = "p";
		}
		if (randomnumber == 32) {
				randomstring = "P";
		}
		if (randomnumber == 33) {
				randomstring = "q";
		}
		if (randomnumber == 34) {
				randomstring = "Q";
		}
		if (randomnumber == 35) {
				randomstring = "r";
		}
		if (randomnumber == 36) {
				randomstring = "R";
		}
		if (randomnumber == 37) {
				randomstring = "s";
		}
		if (randomnumber == 38) {
				randomstring = "S";
		}
		if (randomnumber == 39) {
				randomstring = "t";
		}
		if (randomnumber == 40) {
				randomstring = "T";
		}
		if (randomnumber == 41) {
				randomstring = "u";
		}
		if (randomnumber == 42) {
				randomstring = "U";
		}
		if (randomnumber == 43) {
				randomstring = "v";
		}
		if (randomnumber == 44) {
				randomstring = "V";
		}
		if (randomnumber == 45) {
				randomstring = "w";
		}
		if (randomnumber == 46) {
				randomstring = "W";
		}
		if (randomnumber == 47) {
				randomstring = "x";
		}
		if (randomnumber == 48) {
				randomstring = "X";
		}
		if (randomnumber == 49) {
				randomstring = "y";
		}
		if (randomnumber == 50) {
				randomstring = "Y";
		}
		if (randomnumber == 51) {
				randomstring = "z";
		}
		if (randomnumber == 52) {
				randomstring = "Z";
		}
		if (randomnumber == 53) {
				randomstring = "0";
		}
		if (randomnumber == 54) {
				randomstring = "1";
		}
		if (randomnumber == 55) {
				randomstring = "2";
		}
		if (randomnumber == 56) {
				randomstring = "3";
		}
		if (randomnumber == 57) {
				randomstring = "4";
		}
		if (randomnumber == 58) {
				randomstring = "5";
		}
		if (randomnumber == 59) {
				randomstring = "6";
		}
		if (randomnumber == 60) {
				randomstring = "7";
		}
		if (randomnumber == 61) {
				randomstring = "8";
		}
		if (randomnumber == 62) {
				randomstring = "9";
		}
		randomnumber2 = SketchwareUtil.getRandom((int)(1), (int)(62));
		if (randomnumber2 == 1) {
				randomstring2 = "a";
		}
		if (randomnumber2 == 2) {
				randomstring2 = "A";
		}
		if (randomnumber2 == 3) {
				randomstring2 = "b";
		}
		if (randomnumber2 == 4) {
				randomstring2 = "B";
		}
		if (randomnumber2 == 5) {
				randomstring2 = "c";
		}
		if (randomnumber2 == 6) {
				randomstring2 = "C";
		}
		if (randomnumber2 == 7) {
				randomstring2 = "d";
		}
		if (randomnumber2 == 8) {
				randomstring2 = "D";
		}
		if (randomnumber2 == 9) {
				randomstring2 = "e";
		}
		if (randomnumber2 == 10) {
				randomstring2 = "E";
		}
		if (randomnumber2 == 11) {
				randomstring2 = "f";
		}
		if (randomnumber2 == 12) {
				randomstring2 = "F";
		}
		if (randomnumber2 == 13) {
				randomstring2 = "g";
		}
		if (randomnumber2 == 14) {
				randomstring2 = "G";
		}
		if (randomnumber2 == 15) {
				randomstring2 = "h";
		}
		if (randomnumber2 == 16) {
				randomstring2 = "H";
		}
		if (randomnumber2 == 17) {
				randomstring2 = "i";
		}
		if (randomnumber2 == 18) {
				randomstring2 = "I";
		}
		if (randomnumber2 == 19) {
				randomstring2 = "j";
		}
		if (randomnumber2 == 20) {
				randomstring2 = "J";
		}
		if (randomnumber2 == 21) {
				randomstring2 = "k";
		}
		if (randomnumber2 == 22) {
				randomstring2 = "K";
		}
		if (randomnumber2 == 23) {
				randomstring2 = "l";
		}
		if (randomnumber2 == 24) {
				randomstring2 = "L";
		}
		if (randomnumber2 == 25) {
				randomstring2 = "m";
		}
		if (randomnumber2 == 26) {
				randomstring2 = "M";
		}
		if (randomnumber2 == 27) {
				randomstring2 = "n";
		}
		if (randomnumber2 == 28) {
				randomstring2 = "N";
		}
		if (randomnumber2 == 29) {
				randomstring2 = "o";
		}
		if (randomnumber2 == 30) {
				randomstring2 = "O";
		}
		if (randomnumber2 == 31) {
				randomstring2 = "p";
		}
		if (randomnumber2 == 32) {
				randomstring2 = "P";
		}
		if (randomnumber2 == 33) {
				randomstring2 = "q";
		}
		if (randomnumber2 == 34) {
				randomstring2 = "Q";
		}
		if (randomnumber2 == 35) {
				randomstring2 = "r";
		}
		if (randomnumber2 == 36) {
				randomstring2 = "R";
		}
		if (randomnumber2 == 37) {
				randomstring2 = "s";
		}
		if (randomnumber2 == 38) {
				randomstring2 = "S";
		}
		if (randomnumber2 == 39) {
				randomstring2 = "t";
		}
		if (randomnumber2 == 40) {
				randomstring2 = "T";
		}
		if (randomnumber2 == 41) {
				randomstring2 = "u";
		}
		if (randomnumber2 == 42) {
				randomstring2 = "U";
		}
		if (randomnumber2 == 43) {
				randomstring2 = "v";
		}
		if (randomnumber2 == 44) {
				randomstring2 = "V";
		}
		if (randomnumber2 == 45) {
				randomstring2 = "w";
		}
		if (randomnumber2 == 46) {
				randomstring2 = "W";
		}
		if (randomnumber2 == 47) {
				randomstring2 = "x";
		}
		if (randomnumber2 == 48) {
				randomstring2 = "X";
		}
		if (randomnumber2 == 49) {
				randomstring2 = "y";
		}
		if (randomnumber2 == 50) {
				randomstring2 = "Y";
		}
		if (randomnumber2 == 51) {
				randomstring2 = "z";
		}
		if (randomnumber2 == 52) {
				randomstring2 = "Z";
		}
		if (randomnumber2 == 53) {
				randomstring2 = "0";
		}
		if (randomnumber2 == 54) {
				randomstring2 = "1";
		}
		if (randomnumber2 == 55) {
				randomstring2 = "2";
		}
		if (randomnumber2 == 56) {
				randomstring2 = "3";
		}
		if (randomnumber2 == 57) {
				randomstring2 = "4";
		}
		if (randomnumber2 == 58) {
				randomstring2 = "5";
		}
		if (randomnumber2 == 59) {
				randomstring2 = "6";
		}
		if (randomnumber2 == 60) {
				randomstring2 = "7";
		}
		if (randomnumber2 == 61) {
				randomstring2 = "8";
		}
		if (randomnumber2 == 62) {
				randomstring2 = "9";
		}
		randomnumber3 = SketchwareUtil.getRandom((int)(1), (int)(62));
		if (randomnumber3 == 1) {
				randomstring3 = "a";
		}
		if (randomnumber3 == 2) {
				randomstring3 = "A";
		}
		if (randomnumber3 == 3) {
				randomstring3 = "b";
		}
		if (randomnumber3 == 4) {
				randomstring3 = "B";
		}
		if (randomnumber3 == 5) {
				randomstring3 = "c";
		}
		if (randomnumber3 == 6) {
				randomstring3 = "C";
		}
		if (randomnumber3 == 7) {
				randomstring3 = "d";
		}
		if (randomnumber3 == 8) {
				randomstring3 = "D";
		}
		if (randomnumber3 == 9) {
				randomstring3 = "e";
		}
		if (randomnumber3 == 10) {
				randomstring3 = "E";
		}
		if (randomnumber3 == 11) {
				randomstring3 = "f";
		}
		if (randomnumber3 == 12) {
				randomstring3 = "F";
		}
		if (randomnumber3 == 13) {
				randomstring3 = "g";
		}
		if (randomnumber3 == 14) {
				randomstring3 = "G";
		}
		if (randomnumber3 == 15) {
				randomstring3 = "h";
		}
		if (randomnumber3 == 16) {
				randomstring3 = "H";
		}
		if (randomnumber3 == 17) {
				randomstring3 = "i";
		}
		if (randomnumber3 == 18) {
				randomstring3 = "I";
		}
		if (randomnumber3 == 19) {
				randomstring3 = "j";
		}
		if (randomnumber3 == 20) {
				randomstring3 = "J";
		}
		if (randomnumber3 == 21) {
				randomstring3 = "k";
		}
		if (randomnumber3 == 22) {
				randomstring3 = "K";
		}
		if (randomnumber3 == 23) {
				randomstring3 = "l";
		}
		if (randomnumber3 == 24) {
				randomstring3 = "L";
		}
		if (randomnumber3 == 25) {
				randomstring3 = "m";
		}
		if (randomnumber3 == 26) {
				randomstring3 = "M";
		}
		if (randomnumber3 == 27) {
				randomstring3 = "n";
		}
		if (randomnumber3 == 28) {
				randomstring3 = "N";
		}
		if (randomnumber3 == 29) {
				randomstring3 = "o";
		}
		if (randomnumber3 == 30) {
				randomstring3 = "O";
		}
		if (randomnumber3 == 31) {
				randomstring3 = "p";
		}
		if (randomnumber3 == 32) {
				randomstring3 = "P";
		}
		if (randomnumber3 == 33) {
				randomstring3 = "q";
		}
		if (randomnumber3 == 34) {
				randomstring3 = "Q";
		}
		if (randomnumber3 == 35) {
				randomstring3 = "r";
		}
		if (randomnumber3 == 36) {
				randomstring3 = "R";
		}
		if (randomnumber3 == 37) {
				randomstring3 = "s";
		}
		if (randomnumber3 == 38) {
				randomstring3 = "S";
		}
		if (randomnumber3 == 39) {
				randomstring3 = "t";
		}
		if (randomnumber3 == 40) {
				randomstring3 = "T";
		}
		if (randomnumber3 == 41) {
				randomstring3 = "u";
		}
		if (randomnumber3 == 42) {
				randomstring3 = "U";
		}
		if (randomnumber3 == 43) {
				randomstring3 = "v";
		}
		if (randomnumber3 == 44) {
				randomstring3 = "V";
		}
		if (randomnumber3 == 45) {
				randomstring3 = "w";
		}
		if (randomnumber3 == 46) {
				randomstring3 = "W";
		}
		if (randomnumber3 == 47) {
				randomstring3 = "x";
		}
		if (randomnumber3 == 48) {
				randomstring3 = "X";
		}
		if (randomnumber3 == 49) {
				randomstring3 = "y";
		}
		if (randomnumber3 == 50) {
				randomstring3 = "Y";
		}
		if (randomnumber3 == 51) {
				randomstring3 = "z";
		}
		if (randomnumber3 == 52) {
				randomstring3 = "Z";
		}
		if (randomnumber3 == 53) {
				randomstring3 = "0";
		}
		if (randomnumber3 == 54) {
				randomstring3 = "1";
		}
		if (randomnumber3 == 55) {
				randomstring3 = "2";
		}
		if (randomnumber3 == 56) {
				randomstring3 = "3";
		}
		if (randomnumber3 == 57) {
				randomstring3 = "4";
		}
		if (randomnumber3 == 58) {
				randomstring3 = "5";
		}
		if (randomnumber3 == 59) {
				randomstring3 = "6";
		}
		if (randomnumber3 == 60) {
				randomstring3 = "7";
		}
		if (randomnumber3 == 61) {
				randomstring3 = "8";
		}
		if (randomnumber3 == 62) {
				randomstring3 = "9";
		}
		randomnumber4 = SketchwareUtil.getRandom((int)(1), (int)(62));
		if (randomnumber4 == 1) {
				randomstring4 = "a";
		}
		if (randomnumber4 == 2) {
				randomstring4 = "A";
		}
		if (randomnumber4 == 3) {
				randomstring4 = "b";
		}
		if (randomnumber4 == 4) {
				randomstring4 = "B";
		}
		if (randomnumber4 == 5) {
				randomstring4 = "c";
		}
		if (randomnumber4 == 6) {
				randomstring4 = "C";
		}
		if (randomnumber4 == 7) {
				randomstring4 = "d";
		}
		if (randomnumber4 == 8) {
				randomstring4 = "D";
		}
		if (randomnumber4 == 9) {
				randomstring4 = "e";
		}
		if (randomnumber4 == 10) {
				randomstring4 = "E";
		}
		if (randomnumber4 == 11) {
				randomstring4 = "f";
		}
		if (randomnumber4 == 12) {
				randomstring4 = "F";
		}
		if (randomnumber4 == 13) {
				randomstring4 = "g";
		}
		if (randomnumber4 == 14) {
				randomstring4 = "G";
		}
		if (randomnumber4 == 15) {
				randomstring4 = "h";
		}
		if (randomnumber4 == 16) {
				randomstring4 = "H";
		}
		if (randomnumber4 == 17) {
				randomstring4 = "i";
		}
		if (randomnumber4 == 18) {
				randomstring4 = "I";
		}
		if (randomnumber4 == 19) {
				randomstring4 = "j";
		}
		if (randomnumber4 == 20) {
				randomstring4 = "J";
		}
		if (randomnumber4 == 21) {
				randomstring4 = "k";
		}
		if (randomnumber4 == 22) {
				randomstring4 = "K";
		}
		if (randomnumber4 == 23) {
				randomstring4 = "l";
		}
		if (randomnumber4 == 24) {
				randomstring4 = "L";
		}
		if (randomnumber4 == 25) {
				randomstring4 = "m";
		}
		if (randomnumber4 == 26) {
				randomstring4 = "M";
		}
		if (randomnumber4 == 27) {
				randomstring4 = "n";
		}
		if (randomnumber4 == 28) {
				randomstring4 = "N";
		}
		if (randomnumber4 == 29) {
				randomstring4 = "o";
		}
		if (randomnumber4 == 30) {
				randomstring4 = "O";
		}
		if (randomnumber4 == 31) {
				randomstring4 = "p";
		}
		if (randomnumber4 == 32) {
				randomstring4 = "P";
		}
		if (randomnumber4 == 33) {
				randomstring4 = "q";
		}
		if (randomnumber4 == 34) {
				randomstring4 = "Q";
		}
		if (randomnumber4 == 35) {
				randomstring4 = "r";
		}
		if (randomnumber4 == 36) {
				randomstring4 = "R";
		}
		if (randomnumber4 == 37) {
				randomstring4 = "s";
		}
		if (randomnumber4 == 38) {
				randomstring4 = "S";
		}
		if (randomnumber4 == 39) {
				randomstring4 = "t";
		}
		if (randomnumber4 == 40) {
				randomstring4 = "T";
		}
		if (randomnumber4 == 41) {
				randomstring4 = "u";
		}
		if (randomnumber4 == 42) {
				randomstring4 = "U";
		}
		if (randomnumber4 == 43) {
				randomstring4 = "v";
		}
		if (randomnumber4 == 44) {
				randomstring4 = "V";
		}
		if (randomnumber4 == 45) {
				randomstring4 = "w";
		}
		if (randomnumber4 == 46) {
				randomstring4 = "W";
		}
		if (randomnumber4 == 47) {
				randomstring4 = "x";
		}
		if (randomnumber4 == 48) {
				randomstring4 = "X";
		}
		if (randomnumber4 == 49) {
				randomstring4 = "y";
		}
		if (randomnumber4 == 50) {
				randomstring4 = "Y";
		}
		if (randomnumber4 == 51) {
				randomstring4 = "z";
		}
		if (randomnumber4 == 52) {
				randomstring4 = "Z";
		}
		if (randomnumber4 == 53) {
				randomstring4 = "0";
		}
		if (randomnumber4 == 54) {
				randomstring4 = "1";
		}
		if (randomnumber4 == 55) {
				randomstring4 = "2";
		}
		if (randomnumber4 == 56) {
				randomstring4 = "3";
		}
		if (randomnumber4 == 57) {
				randomstring4 = "4";
		}
		if (randomnumber4 == 58) {
				randomstring4 = "5";
		}
		if (randomnumber4 == 59) {
				randomstring4 = "6";
		}
		if (randomnumber4 == 60) {
				randomstring4 = "7";
		}
		if (randomnumber4 == 61) {
				randomstring4 = "8";
		}
		if (randomnumber4 == 62) {
				randomstring4 = "9";
		}
		randomnumber5 = SketchwareUtil.getRandom((int)(1), (int)(62));
		if (randomnumber5 == 1) {
				randomstring5 = "a";
		}
		if (randomnumber5 == 2) {
				randomstring5 = "A";
		}
		if (randomnumber5 == 3) {
				randomstring5 = "b";
		}
		if (randomnumber5 == 4) {
				randomstring5 = "B";
		}
		if (randomnumber5 == 5) {
				randomstring5 = "c";
		}
		if (randomnumber5 == 6) {
				randomstring5 = "C";
		}
		if (randomnumber5 == 7) {
				randomstring5 = "d";
		}
		if (randomnumber5 == 8) {
				randomstring5 = "D";
		}
		if (randomnumber5 == 9) {
				randomstring5 = "e";
		}
		if (randomnumber5 == 10) {
				randomstring5 = "E";
		}
		if (randomnumber5 == 11) {
				randomstring5 = "f";
		}
		if (randomnumber5 == 12) {
				randomstring5 = "F";
		}
		if (randomnumber5 == 13) {
				randomstring5 = "g";
		}
		if (randomnumber5 == 14) {
				randomstring5 = "G";
		}
		if (randomnumber5 == 15) {
				randomstring5 = "h";
		}
		if (randomnumber5 == 16) {
				randomstring5 = "H";
		}
		if (randomnumber5 == 17) {
				randomstring5 = "i";
		}
		if (randomnumber5 == 18) {
				randomstring5 = "I";
		}
		if (randomnumber5 == 19) {
				randomstring5 = "j";
		}
		if (randomnumber5 == 20) {
				randomstring5 = "J";
		}
		if (randomnumber5 == 21) {
				randomstring5 = "k";
		}
		if (randomnumber5 == 22) {
				randomstring5 = "K";
		}
		if (randomnumber5 == 23) {
				randomstring5 = "l";
		}
		if (randomnumber5 == 24) {
				randomstring5 = "L";
		}
		if (randomnumber5 == 25) {
				randomstring5 = "m";
		}
		if (randomnumber5 == 26) {
				randomstring5 = "M";
		}
		if (randomnumber5 == 27) {
				randomstring5 = "n";
		}
		if (randomnumber5 == 28) {
				randomstring5 = "N";
		}
		if (randomnumber5 == 29) {
				randomstring5 = "o";
		}
		if (randomnumber5 == 30) {
				randomstring5 = "O";
		}
		if (randomnumber5 == 31) {
				randomstring5 = "p";
		}
		if (randomnumber5 == 32) {
				randomstring5 = "P";
		}
		if (randomnumber5 == 33) {
				randomstring5 = "q";
		}
		if (randomnumber5 == 34) {
				randomstring5 = "Q";
		}
		if (randomnumber5 == 35) {
				randomstring5 = "r";
		}
		if (randomnumber5 == 36) {
				randomstring5 = "R";
		}
		if (randomnumber5 == 37) {
				randomstring5 = "s";
		}
		if (randomnumber5 == 38) {
				randomstring5 = "S";
		}
		if (randomnumber5 == 39) {
				randomstring5 = "t";
		}
		if (randomnumber5 == 40) {
				randomstring5 = "T";
		}
		if (randomnumber5 == 41) {
				randomstring5 = "u";
		}
		if (randomnumber5 == 42) {
				randomstring5 = "U";
		}
		if (randomnumber5 == 43) {
				randomstring5 = "v";
		}
		if (randomnumber5 == 44) {
				randomstring5 = "V";
		}
		if (randomnumber5 == 45) {
				randomstring5 = "w";
		}
		if (randomnumber5 == 46) {
				randomstring5 = "W";
		}
		if (randomnumber5 == 47) {
				randomstring5 = "x";
		}
		if (randomnumber5 == 48) {
				randomstring5 = "X";
		}
		if (randomnumber5 == 49) {
				randomstring5 = "y";
		}
		if (randomnumber5 == 50) {
				randomstring5 = "Y";
		}
		if (randomnumber5 == 51) {
				randomstring5 = "z";
		}
		if (randomnumber5 == 52) {
				randomstring5 = "Z";
		}
		if (randomnumber5 == 53) {
				randomstring5 = "0";
		}
		if (randomnumber5 == 54) {
				randomstring5 = "1";
		}
		if (randomnumber5 == 55) {
				randomstring5 = "2";
		}
		if (randomnumber5 == 56) {
				randomstring5 = "3";
		}
		if (randomnumber5 == 57) {
				randomstring5 = "4";
		}
		if (randomnumber5 == 58) {
				randomstring5 = "5";
		}
		if (randomnumber5 == 59) {
				randomstring5 = "6";
		}
		if (randomnumber5 == 60) {
				randomstring5 = "7";
		}
		if (randomnumber5 == 61) {
				randomstring5 = "8";
		}
		if (randomnumber5 == 62) {
				randomstring5 = "9";
		}
		endstring = randomstring.concat(randomstring2.concat(randomstring3.concat(randomstring4.concat(randomstring5))));
	}
	
	
	public void _Shape(final double _t1, final double _t2, final double _b1, final double _b2, final String _Background, final double _Stroke, final String _stroke, final double _Elevation, final View _view) {
		android.graphics.drawable.GradientDrawable gs = new android.graphics.drawable.GradientDrawable();
		
		gs.setColor(Color.parseColor(_Background));
		
		gs.setStroke((int)_Stroke, Color.parseColor(_stroke));
		
		gs.setCornerRadii(new float[]{(int)_t1,(int)_t1,(int)_t2,(int)_t2,(int)_b1,(int)_b1,(int)_b2,(int)_b2});
		
		_view.setBackground(gs);
		_view.setElevation((int)_Elevation);
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