import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.EditText
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var colorBox: View
    private lateinit var redSwitch: Switch
    private lateinit var greenSwitch: Switch
    private lateinit var blueSwitch: Switch
    private lateinit var redSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var redValue: EditText
    private lateinit var greenValue: EditText
    private lateinit var blueValue: EditText
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        colorBox = findViewById(R.id.colorBox)
        redSwitch = findViewById(R.id.redSwitch)
        greenSwitch = findViewById(R.id.greenSwitch)
        blueSwitch = findViewById(R.id.blueSwitch)
        redSeekBar = findViewById(R.id.redSeekBar)
        greenSeekBar = findViewById(R.id.greenSeekBar)
        blueSeekBar = findViewById(R.id.blueSeekBar)
        redValue = findViewById(R.id.redValue)
        greenValue = findViewById(R.id.greenValue)
        blueValue = findViewById(R.id.blueValue)
        resetButton = findViewById(R.id.resetButton)

        // Set listeners
        setSwitchListener(redSwitch, redSeekBar, redValue)
        setSwitchListener(greenSwitch, greenSeekBar, greenValue)
        setSwitchListener(blueSwitch, blueSeekBar, blueValue)

        setResetButtonListener()
    }

    private fun setSwitchListener(switch: Switch, seekBar: SeekBar, editText: EditText) {
        switch.setOnCheckedChangeListener { _, isChecked ->
            seekBar.isEnabled = isChecked
            editText.isEnabled = isChecked
        }
    }

    private fun setResetButtonListener() {
        resetButton.setOnClickListener {
            redSwitch.isChecked = false
            greenSwitch.isChecked = false
            blueSwitch.isChecked = false
            redSeekBar.progress = 0
            greenSeekBar.progress = 0
            blueSeekBar.progress = 0
            redValue.text.clear()
            greenValue.text.clear()
            blueValue.text.clear()
            updateColor()
        }
    }

    private fun updateColor() {
        val red = redSeekBar.progress
        val green = greenSeekBar.progress
        val blue = blueSeekBar.progress
        val color = Color.rgb(red, green, blue)
        colorBox.setBackgroundColor(color)
    }
}
