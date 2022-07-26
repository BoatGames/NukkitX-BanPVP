package BoatMC;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.util.List;

public class Main extends PluginBase implements Listener
{
    public List<String> allowLevels;

    public void onEnable() {
        super.onEnable();
        this.saveDefaultConfig();
        this.allowLevels = new Config(this.getDataFolder() + "/config.yml", 2).getStringList("AllowLevels");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public void onLoad() {
        super.onLoad();
    }

    public void onDisable() {
        super.onDisable();
    }

    //  EntityDamageByEntityEvent: 当一个实体受到另外一个实体伤害时触发该事件
    @EventHandler
    public void PvP(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player && event.getDamager() instanceof Player) {
            Player player = (Player) event.getEntity();
                event.setDamage(0);
                event.setKnockBack(0);
                event.setCancelled();
        }
    }

}