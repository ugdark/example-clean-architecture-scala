package example.domain.support

import java.util.concurrent.atomic.AtomicLong

/**
 * @see [ID生成大全](https://qiita.com/kawasima/items/6b0f47a60c9cb5ffb5c4)
 */
object IdGenerator {

  def uuid:String = java.util.UUID.randomUUID().toString

  private val atomicLong = new AtomicLong(0L)

  def idLong: Long = atomicLong.getAndIncrement()

}
