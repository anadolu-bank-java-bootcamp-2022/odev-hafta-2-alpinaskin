package com.gokhantamkoc.javabootcamp.odevhafta2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class PlayWorldOfMagic implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(PlayWorldOfMagic.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int maxNumOfAttacksAllowed = 9;
		String[] magicianSpells = createSpellNameRepository();
		float[] spellDamageInfo = createSpellDamageRepository();
		String[] bossNames = createBossNameRepository();
		float[] bossHps = createBossHPRepository();
		
		int minNumberSpellsUsed = resolveBattle(
				magicianSpells, 
				spellDamageInfo, 
				bossNames, 
				bossHps);
		
		if (minNumberSpellsUsed > maxNumOfAttacksAllowed) {
			System.out.println("Magician died!");
		} else if (minNumberSpellsUsed > 0 && minNumberSpellsUsed <= maxNumOfAttacksAllowed) {
			System.out.println("Magician won the battle!");
		} else {
			System.out.println("Result is not correct!");
		}
	}
	
	public static int resolveBattle(
			String[] magicianSpells,
			float[] spellDamageInfo,
			String[] bossNames,
			float[] bossHPs
			) {
		
		int spellsUsed = 0;
		// ______ BASLANGIC _______ Kodunuz buradan baslamali

		float maxSpellDamage = 0.0f;

		if(bossHPs.length <= 0)
			throw new IllegalArgumentException();

		// bütün spell damagelerden en büyük olanı bul.
		for(float spellDamage: spellDamageInfo) {
			if(Float.compare(spellDamage, maxSpellDamage) > 0)
				maxSpellDamage = spellDamage;
		}

		// bütün bossları gezerek canlarını spell uygula
		for(float bossHp: bossHPs) {
			do{
			spellsUsed++;
			bossHp -= maxSpellDamage;
			}
			while(Float.compare(bossHp, 0.0f) > 0); // küçük ya da eşitse
		}

		// ______ SON _______ Kodunuz burada bitmeli
		/* NOT: ______ BASLANGIC _______ ve ______ SON _______ 
		 * arasina istediginiz kadar sayida satir ekleyebilirsiniz.
		 */
		return spellsUsed;
	}
	
	public static String[] createSpellNameRepository() {
		return new String[]{"Ice Storm", "Chain Lightning", "Magic Missile"};
	}
	
	public static float[] createSpellDamageRepository() {
		return new float[]{40.0f, 30.0f, 5.0f};
	}
	
	public static String[] createBossNameRepository() {
		return new String[]{"Dire Rat", "Skeleton Knight", "Undead King"};
	}
	
	public static float[] createBossHPRepository() {
		return new float[]{15.0f, 45.0f, 60.0f};
	}
}
