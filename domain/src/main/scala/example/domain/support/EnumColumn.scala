package example.domain.support

trait EnumColumn {

  // 識別子
  val id: Int
  // Presenter層での数字以外のkeywordになる。基本的にはclass名と依存させる。
  val keyword: String = this.getClass.getSimpleName.replace("$", "")

  // 表示
  val name: String

}
