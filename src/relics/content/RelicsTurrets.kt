package relics.content

import mindustry.content.*
import mindustry.entities.bullet.BasicBulletType
import mindustry.gen.Sounds
import mindustry.type.Category
import mindustry.world.Block
import mindustry.world.blocks.defense.turrets.ItemTurret
import mindustry.type.ItemStack.with;

class RelicsTurrets {

    fun load() {

        solo = object : ItemTurret("solo"){}.apply {
            localizedName = "Solo"
            description = "Fires single bullets at enemies, with a farther range than [gold]Duo."
            requirements(Category.turret, with(Items.copper, 35), true)
            range = 130f
            reload = 22f
            ammo(
                Items.copper, BasicBulletType(2.5f, 9f).apply{
                    width = 7f
                    height = 9f
                    lifetime = 60f
                    ammoMultiplier = 2f
                },
                Items.graphite, BasicBulletType(3.5f, 18f).apply{
                    width = 9f
                    height = 12f
                    lifetime = 60f
                    ammoMultiplier = 4f
                    reloadMultiplier = .6f
                },
                Items.silicon, BasicBulletType(3f, 12f).apply{
                    width = 7f
                    height = 9f
                    lifetime = 60f
                    homingPower = .1f
                    reloadMultiplier = 1.5f
                    ammoMultiplier = 5f
                })
            shoot.shots = 1
            shootCone = 10f
            shootY = 3f
            ammoUseEffect = Fx.casing1
            health = 250
            inaccuracy = 1.5f
            rotateSpeed = 10f
        }

        stream = object : ItemTurret("stream"){}.apply {
            localizedName = "Stream"
            description = "Fires many bullets very quickly."
            requirements(Category.turret, with(Items.copper, 30, Items.lead, 45))
            range = 148f
            reload = 7f
            ammo(Items.lead, RelicsBullets.standardCopperFast)
            shoot.shots = 1
            shootCone = 17f
            shootY = 3f
            ammoUseEffect = Fx.casing1
            health = 280
            inaccuracy = 2.8f
            rotateSpeed = 8f
        }

        split = object : ItemTurret("split"){}.apply {
            localizedName = "Split"
            description = "Fires a spread of 7 bullets. Lower range but higher damage output than [gold]Stream."
            requirements(Category.turret, with(Items.copper, 45, Items.lead, 55))
            range = 100f
            reload = 30f
            ammo(Items.lead, RelicsBullets.standardCopperFast)
            shoot.shots = 7
//            spread = 6f
            shootCone = 45f
            ammoUseEffect = Fx.casing3
            ammoEjectBack = 1.7f;
            recoil = 1.3f;
//            alternate = false
            health = 280
            inaccuracy = 2.0f
            rotateSpeed = 8f
        }

        fragment = object : ItemTurret("fragment"){}.apply {
            localizedName = "Fragment"
            description = "Shoots bullets that explode into shrapnel."
            health = 310
            ammo(Items.coal, RelicsBullets.fragmentBullet)
            shoot.shots = 3
//            spread = 9f
            shootCone = 20f
            ammoUseEffect = Fx.casing3
            ammoEjectBack = 1.5f;
            inaccuracy = 9f
            targetAir = false
            reload = 55f
            shake = 2f
            range = 220f
            shootSound = Sounds.bigshot
            shootEffect = Fx.shootBig
            requirements(Category.turret, with(Items.graphite, 120, Items.titanium, 130))
            size = 2;
            recoil = 2.0f;
        }

        incinerate = object : ItemTurret("incinerate"){}.apply {
            localizedName = "Incinerate"
            description = "Advanced version of [gold]Scorch[white]. Very high damage, low to medium range."
            health = 440
            ammo(Items.coal, RelicsBullets.flameHot,
                Items.pyratite, RelicsBullets.pyraFlameHot)
            requirements(Category.turret, with(Items.graphite, 70, Items.titanium, 85))
            shoot.shots = 1
            range = 75f
            inaccuracy = 4f
            rotateSpeed = 8f
            recoil = 0f
            targetAir = false
            reload = 6f
            shootEffect = Fx.none
            shootSound = Sounds.flame
            shootCone = 50f
            size = 2
        }
    }

    companion object{
        lateinit var solo: Block
        lateinit var stream: Block
        lateinit var split: Block
        lateinit var fragment: Block
        lateinit var incinerate: Block
    }
}