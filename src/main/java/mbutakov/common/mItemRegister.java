package mbutakov.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mbutakov.armor.Armor2021.Armor2021;
import mbutakov.armor.JokerArmor.JokerArmor;
import mbutakov.armor.KrampusArmor.KrampusArmor;
import mbutakov.armor.NaziArmor.NaziArmor;
import mbutakov.armor.PlagueDoctorArmor.PlagueDoctor;
import mbutakov.armor.RedArmyArmor.RedArmyArmor;
import mbutakov.armor.SantaArmor.SantaArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class mItemRegister {
	
	public static final ArmorMaterial RFarmor = EnumHelper.addArmorMaterial("rfarmor", 15, new int[] { 2, 6, 4, 2 }, 0);
    public static final ArmorMaterial NYarmor = EnumHelper.addArmorMaterial("nyarmor", 22, new int[] { 3, 8, 5, 3 }, 0);
    public static final ArmorMaterial krampus = EnumHelper.addArmorMaterial("krampus", 22, new int[] { 3, 8, 6, 3 }, 0);
    public static final ArmorMaterial ny2020armor = EnumHelper.addArmorMaterial("ny2020armor", 22, new int[] { 3, 7, 5, 3 }, 0);
	
	public static Item a21h,a21c,a21l,a21b;
	public static Item pdh,pdc,pdp,pdb;
	public static Item kh,kc,kp,kb;
	public static Item jh,jc,jp,jb;
	public static Item rh,rc,rp,rb;
	public static Item nh,nc,np,nb;
	public static Item sh,sc,sp,sb;

	
	public static void registerItems() {
		a21h = new Armor2021.Helmet(ny2020armor,0, 0);
		a21c = new Armor2021.Body(ny2020armor,0, 1);
		a21l = new Armor2021.Pants(ny2020armor,0, 2);
		a21b = new Armor2021.Boots(ny2020armor,0, 3);
		GameRegistry.registerItem(a21h, a21h.getUnlocalizedName());
		GameRegistry.registerItem(a21c, a21c.getUnlocalizedName());
		GameRegistry.registerItem(a21l, a21l.getUnlocalizedName());
		GameRegistry.registerItem(a21b, a21b.getUnlocalizedName());
		pdh = new PlagueDoctor.Helmet(krampus,0, 0);
		pdc = new PlagueDoctor.Body(krampus,0, 1);
		pdp = new PlagueDoctor.Pants(krampus,0, 2);
		pdb = new PlagueDoctor.Boots(krampus,0, 3);
		GameRegistry.registerItem(pdh, pdh.getUnlocalizedName());
		GameRegistry.registerItem(pdc, pdc.getUnlocalizedName());
		GameRegistry.registerItem(pdp, pdp.getUnlocalizedName());
		GameRegistry.registerItem(pdb, pdb.getUnlocalizedName());
		kh = new KrampusArmor.Helmet(krampus,0, 0);
		kc = new KrampusArmor.Body(krampus,0, 1);
		kp = new KrampusArmor.Pants(krampus,0, 2);
		kb = new KrampusArmor.Boots(krampus,0, 3);
		GameRegistry.registerItem(kh, kh.getUnlocalizedName());
		GameRegistry.registerItem(kc, kc.getUnlocalizedName());
		GameRegistry.registerItem(kp, kp.getUnlocalizedName());
		GameRegistry.registerItem(kb, kb.getUnlocalizedName());
		jh = new JokerArmor.Helmet(NYarmor,0, 0);
		jc = new JokerArmor.Body(NYarmor,0, 1);
		jp = new JokerArmor.Pants(NYarmor,0, 2);
		jb = new JokerArmor.Boots(NYarmor,0, 3);
		GameRegistry.registerItem(jh, jh.getUnlocalizedName());
		GameRegistry.registerItem(jc, jc.getUnlocalizedName());
		GameRegistry.registerItem(jp, jp.getUnlocalizedName());
		GameRegistry.registerItem(jb, jb.getUnlocalizedName());
		rh = new RedArmyArmor.Helmet(NYarmor,0, 0);
		rc = new RedArmyArmor.Body(NYarmor,0, 1);
		rp = new RedArmyArmor.Pants(NYarmor,0, 2);
		rb = new RedArmyArmor.Boots(NYarmor,0, 3);
		GameRegistry.registerItem(rh, rh.getUnlocalizedName());
		GameRegistry.registerItem(rc, rc.getUnlocalizedName());
		GameRegistry.registerItem(rp, rp.getUnlocalizedName());
		GameRegistry.registerItem(rb, rb.getUnlocalizedName());
		nh = new NaziArmor.Helmet(NYarmor,0, 0);
		nc = new NaziArmor.Body(NYarmor,0, 1);
		np = new NaziArmor.Pants(NYarmor,0, 2);
		nb = new NaziArmor.Boots(NYarmor,0, 3);
		GameRegistry.registerItem(nh, nh.getUnlocalizedName());
		GameRegistry.registerItem(nc, nc.getUnlocalizedName());
		GameRegistry.registerItem(np, np.getUnlocalizedName());
		GameRegistry.registerItem(nb, nb.getUnlocalizedName());
		sh = new SantaArmor.Helmet(NYarmor,0, 0);
		sc = new SantaArmor.Body(NYarmor,0, 1);
		sp = new SantaArmor.Pants(NYarmor,0, 2);
		sb = new SantaArmor.Boots(NYarmor,0, 3);
		GameRegistry.registerItem(sh, sh.getUnlocalizedName());
		GameRegistry.registerItem(sc, sc.getUnlocalizedName());
		GameRegistry.registerItem(sp, sp.getUnlocalizedName());
		GameRegistry.registerItem(sb, sb.getUnlocalizedName());
	}
	
	public static void  langItemReg() {
	    LanguageRegistry.addName(sh, "Шапка Деда Мороза");
	    LanguageRegistry.addName(sc, "Шуба Деда Мороза");
	    LanguageRegistry.addName(sp, "Штаны Деда Мороза");
	    LanguageRegistry.addName(sb, "Валенки Деда Мороза");
	    LanguageRegistry.addName(jh, "Маска Джокера");
	    LanguageRegistry.addName(jc, "Тело Джокера");
	    LanguageRegistry.addName(jp, "Штаны Джокера");
	    LanguageRegistry.addName(jb, "Ботинки Джокера");
	    LanguageRegistry.addName(kh, "Голова Крампуса");
	    LanguageRegistry.addName(kc, "Плащ Крампуса");
	    LanguageRegistry.addName(kp, "Лапы Крампуса");
	    LanguageRegistry.addName(kb, "Копыта Крампуса");
	    LanguageRegistry.addName(rh, "Шлем \"Красная звезда\"");
	    LanguageRegistry.addName(rc, "Нагрудник \"Красная звезда\"");
	    LanguageRegistry.addName(rp, "Штаны \"Красная звезда\"");
	    LanguageRegistry.addName(rb, "Ботинки \"Красная звезда\"");
	    LanguageRegistry.addName(nh, "Шлем \"Граммар\"");
	    LanguageRegistry.addName(nc, "Нагрудник \"Граммар\"");
	    LanguageRegistry.addName(np, "Штаны \"Граммар\"");
	    LanguageRegistry.addName(nb, "Ботини \"Граммар\"");
	    LanguageRegistry.addName(pdh, "Маска сибирского доктора");
	    LanguageRegistry.addName(pdc, "Пиджак сибирского доктора");
	    LanguageRegistry.addName(pdp, "Штаны сибирского доктора");
	    LanguageRegistry.addName(pdb, "Ботинки сибирского доктора");
	    LanguageRegistry.addName(a21h, "Шлем снегорождённого");
	    LanguageRegistry.addName(a21c, "Свитер с оленями");
	    LanguageRegistry.addName(a21l, "Штаны берёза");
	    LanguageRegistry.addName(a21b, "Укрепленные валенки");
	}
}
