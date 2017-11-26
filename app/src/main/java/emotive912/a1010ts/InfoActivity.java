package emotive912.a1010ts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    @BindView(R.id.textBarometer)
    TextView textBarometer;
    @BindView(R.id.textAccelerometer)
    TextView textAccelerometer;
    @BindView(R.id.textTemp)
    TextView textTemp;
    @BindView(R.id.textMagnetometer)
    TextView textMagnetometer;
    @BindView(R.id.textGyroscope)
    TextView textGyroscope;
    @BindView(R.id.textLight)
    TextView textLight;
    @BindView(R.id.textViewres)
    TextView tvRes;
    Mqtthelper mMqtthelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        startMqtt();

    }

    private void startMqtt() {
        mMqtthelper = new Mqtthelper(getApplicationContext());
        mMqtthelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {

            }

            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                tvRes.setText(message.toString());
                try {
                    JSONObject jsonObject = new JSONObject(message.toString());
                    JSONArray jsAr = jsonObject.getJSONArray("values");
                    switch (jsonObject.getString("sensorType")) {
                        case "TEMPERATURE":
                            textTemp.setText(jsAr.toString());
                            break;
                        case "BAROMETER":
                            textBarometer.setText(jsAr.toString());
                            break;
                        case "ACCELEROMETER":
                            textAccelerometer.setText(jsAr.toString());
                            break;
                        case "MAGNETOMETER":
                            textMagnetometer.setText(jsAr.toString());
                            break;
                        case "GYROSCOPE":
                            textGyroscope.setText(jsAr.toString());
                            break;
                        case "LIGHT":
                            textLight.setText(jsAr.toString());
                            break;
                    }
                } catch (JSONException jsEx){

                }

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
    }
}
