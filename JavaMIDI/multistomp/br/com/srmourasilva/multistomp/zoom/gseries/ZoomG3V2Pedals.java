package br.com.srmourasilva.multistomp.zoom.gseries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import br.com.srmourasilva.domain.multistomp.Effect;
import br.com.srmourasilva.domain.multistomp.Param;

public class ZoomG3V2Pedals {
	public static Map<Integer, String> getEffectsNames() {
		Map<Integer, String> retorno = new HashMap<>();

		retorno.put(0, "M-Filter");
		retorno.put(1, "TheVibe");
		retorno.put(2, "Z-Organ");
		retorno.put(3, "Slicer");
		retorno.put(4, "PhaseDly");
		retorno.put(5, "FilterDly");
		retorno.put(6, "PitchDly");
		retorno.put(7, "StereoDly");
		retorno.put(8, "BitCrush");
		retorno.put(9, "Bomber");
		retorno.put(10, "DuoPhase");
		retorno.put(11, "MonoSynth");
		retorno.put(12, "SeqFLTR");
		retorno.put(13, "RndmFLTR");
		retorno.put(14, "WarpPhase");
		retorno.put(15, "TrgHldDly");
		retorno.put(16, "Cho+Dly");
		retorno.put(17, "Cho+Rev");
		retorno.put(18, "Dly+Rev");
		retorno.put(19, "Comp+Phsr");
		retorno.put(20, "Comp+AWah");
		retorno.put(21, "FLG+VCho");
		retorno.put(22, "Comp+OD");
		retorno.put(23, "COMP");
		retorno.put(24, "RackComp");
		retorno.put(25, "M Comp");
		retorno.put(26, "SlowATTCK");
		retorno.put(27, "ZNR");
		retorno.put(28, "NoiseGate");
		retorno.put(29, "DirtyGate");
		retorno.put(30, "GraphicEQ");
		retorno.put(31, "ParaEQ");
		retorno.put(32, "CombFLTR");
		retorno.put(33, "AutoWah");
		retorno.put(34, "Resonance");
		retorno.put(35, "Step");
		retorno.put(36, "Cry");
		retorno.put(37, "Octave");
		retorno.put(38, "Tremolo");
		retorno.put(39, "Phaser");
		retorno.put(40, "RingMod");
		retorno.put(41, "Chorus");
		retorno.put(42, "Detune");
		retorno.put(43, "VintageCE");
		retorno.put(44, "StereoCho");
		retorno.put(45, "Ensemble");
		retorno.put(46, "VinFLNGR");
		retorno.put(47, "DynaFLNGR");
		retorno.put(48, "Vibrato");
		retorno.put(49, "PitchSHFT");
		retorno.put(50, "BendCho");
		retorno.put(51, "MonoPitch");
		retorno.put(52, "HPS");
		retorno.put(53, "Delay");
		retorno.put(54, "TapeEcho");
		retorno.put(55, "ModDelay");
		retorno.put(56, "AnalogDly");
		retorno.put(57, "ReverseDL");
		retorno.put(58, "MultiTapD");
		retorno.put(59, "DynaDelay");
		retorno.put(60, "Hall");
		retorno.put(61, "Room");
		retorno.put(62, "TiledRoom");
		retorno.put(63, "Spring");
		retorno.put(64, "Arena");
		retorno.put(65, "EarlyRef");
		retorno.put(66, "Air");
		retorno.put(67, "PedalVx");
		retorno.put(68, "PedalCry");
		retorno.put(69, "PDL Pitch");
		retorno.put(70, "PDL MnPit");
		retorno.put(71, "Booster");
		retorno.put(72, "OverDrive");
		retorno.put(73, "T Scream");
		retorno.put(74, "Governor");
		retorno.put(75, "Dist+");
		retorno.put(76, "Dist 1");
		retorno.put(77, "Squeak");
		retorno.put(78, "FuzzSmile");
		retorno.put(79, "GreatMuff");
		retorno.put(80, "MetalWRLD");
		retorno.put(81, "HotBox");
		retorno.put(82, "Z Wild");
		retorno.put(83, "Lead");
		retorno.put(84, "ExtremeDS");
		retorno.put(85, "Aco.Sim");
		retorno.put(86, "Z Clean");
		retorno.put(87, "Z MP1");
		retorno.put(88, "Z Bottom");
		retorno.put(89, "Z Dream");
		retorno.put(90, "Z Scream");
		retorno.put(91, "Z Neos");
		retorno.put(92, "FD COMBO");
		retorno.put(93, "VX COMBO");
		retorno.put(94, "US BLUES");
		retorno.put(95, "BG CRUNCH");
		retorno.put(96, "HW STACK");
		retorno.put(97, "TANGERINE");
		retorno.put(98, "MS CRUNCH");
		retorno.put(99, "MS DRIVE");
		retorno.put(100, "BG DRIVE");
		retorno.put(101, "DZ DRIVE");
		retorno.put(102, "TW ROCK");
		retorno.put(103, "MATCH 30");
		retorno.put(104, "FD VIBRO");
		retorno.put(105, "HD Reverb");
		retorno.put(106, "Flanger");
		retorno.put(107, "None");
		retorno.put(108, "TONE CITY");
		retorno.put(109, "B-BREAKER");
		retorno.put(110, "BGN DRIVE");
		retorno.put(111, "DELUXE-R");
		retorno.put(112, "ALIEN");
		retorno.put(113, "REVO-1");
		retorno.put(114, "CAR DRIVE");
		retorno.put(115, "MS 1959");
		retorno.put(116, "VX JMI");
		
		return retorno;
	}

	public static Effect getEffect(int idEffect) throws IOException {
		String fileName = "D:\\Mateus\\JavaPedalMIDI\\JavaMIDI\\multistomp\\br\\com\\srmourasilva\\multistomp\\zoom\\gseries\\zoom-G3X-defaults-min.json";
		Map<String, JsonObject> jsonEffects = readJsonEffectsOf(fileName);

		Effect effect = new Effect(idEffect, getEffectsNames().get(idEffect));
		
		JsonArray controllers = jsonEffects.get(effect.getName()).get("Ctrl").asArray();

		for (JsonValue controller : controllers)
			effect.addParam(generateParam(controller.asObject()));

		return effect;
	}

	private static Map<String, JsonObject> readJsonEffectsOf(String fileName) throws FileNotFoundException, IOException {
		Reader reader = new FileReader(fileName);
		JsonObject value = Json.parse(reader).asObject();
		reader.close();

		JsonArray effects = value.get("Effect").asArray();
		
		Map<String, JsonObject> jsonEffects = new HashMap<>();
		for (JsonValue effect : effects)
			jsonEffects.put(effect.asObject().get("name").asString(), effect.asObject());

		return jsonEffects;
	}

	private static Param generateParam(JsonObject param) {
		return new Param(
			param.get("name").asString(),
			0,
			Integer.parseInt(param.get("max").asString()),
			Integer.parseInt(param.get("default").asString()),
			1
		);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(getEffect(116));
	}
}
