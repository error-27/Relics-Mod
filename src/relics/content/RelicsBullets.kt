package relics.content

import mindustry.content.Fx
import mindustry.content.StatusEffects
import mindustry.ctype.ContentList
import mindustry.entities.bullet.BasicBulletType
import mindustry.entities.bullet.BulletType

class RelicsBullets : ContentList {
    override fun load() {
        standardCopperFast = object : BasicBulletType(2.5f, 11f){}.apply {
            width = 7f
            height = 9f
            lifetime = 60f
            shootEffect = Fx.shootSmall
            smokeEffect = Fx.shootSmallSmoke
            ammoMultiplier = 2f
        }

        flameHot = object : BulletType(4f, 40f){}.apply {
            ammoMultiplier = 3f
            hitSize = 8f
            lifetime = 18f
            pierce = true
            collidesAir = false
            statusDuration = 60f * 4.3f
            shootEffect = Fx.shootSmallFlame
            hitEffect = Fx.hitFlameSmall
            despawnEffect = Fx.none
            status = StatusEffects.burning
            keepVelocity = false
            hittable = false
        }

        pyraFlameHot = object : BulletType(4.75f, 70f){}.apply {
            ammoMultiplier = 6f
            hitSize = 7f
            lifetime = 18f
            pierce = true
            collidesAir = false
            statusDuration = 60f * 10
            shootEffect = Fx.shootPyraFlame
            hitEffect = Fx.hitFlameSmall
            despawnEffect = Fx.none
            status = StatusEffects.burning
            hittable = false
        }
    }
    companion object {
        lateinit var standardCopperFast : BulletType
        lateinit var flameHot : BulletType; lateinit var pyraFlameHot : BulletType
    }
}