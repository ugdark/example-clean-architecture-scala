package example.domain.basic

import example.domain.support.{Enum, EnumColumn}

sealed abstract class Prefecture(
    override val id: Int,
    override val name: String
) extends EnumColumn

/**
  * 都道府県のNoneは未設定を表す
  */
object Prefecture extends Enum[Prefecture] {

  final case object Hokkaido  extends Prefecture(1, "北海道")
  final case object Aomori    extends Prefecture(2, "青森県")
  final case object Iwate     extends Prefecture(3, "岩手県")
  final case object Miyagi    extends Prefecture(4, "宮城県")
  final case object Akita     extends Prefecture(5, "秋田県")
  final case object Yamagata  extends Prefecture(6, "山形県")
  final case object Fukushima extends Prefecture(7, "福島県")
  final case object Ibaraki   extends Prefecture(8, "茨城県")
  final case object Tochigi   extends Prefecture(9, "栃木県")
  final case object Gunma     extends Prefecture(10, "群馬県")
  final case object Saitama   extends Prefecture(11, "埼玉県")
  final case object Chiba     extends Prefecture(12, "千葉県")
  final case object Tokyo     extends Prefecture(13, "東京都")
  final case object Kanagawa  extends Prefecture(14, "神奈川県")
  final case object Niigata   extends Prefecture(15, "新潟県")
  final case object Toyama    extends Prefecture(16, "富山県")
  final case object Ishikawa  extends Prefecture(17, "石川県")
  final case object Fukui     extends Prefecture(18, "福井県")
  final case object Yamanashi extends Prefecture(19, "山梨県")
  final case object Nagano    extends Prefecture(20, "長野県")
  final case object Gifu      extends Prefecture(21, "岐阜県")
  final case object Shizuoka  extends Prefecture(22, "静岡県")
  final case object Aichi     extends Prefecture(23, "愛知県")
  final case object Mie       extends Prefecture(24, "三重県")
  final case object Shiga     extends Prefecture(25, "滋賀県")
  final case object Kyoto     extends Prefecture(26, "京都府")
  final case object Osaka     extends Prefecture(27, "大阪府")
  final case object Hyogo     extends Prefecture(28, "兵庫県")
  final case object Nara      extends Prefecture(29, "奈良県")
  final case object Wakayama  extends Prefecture(30, "和歌山県")
  final case object Tottori   extends Prefecture(31, "鳥取県")
  final case object Shimane   extends Prefecture(32, "島根県")
  final case object Okayama   extends Prefecture(33, "岡山県")
  final case object Hiroshima extends Prefecture(34, "広島県")
  final case object Yamaguchi extends Prefecture(35, "山口県")
  final case object Tokushima extends Prefecture(36, "徳島県")
  final case object Kagawa    extends Prefecture(37, "香川県")
  final case object Ehime     extends Prefecture(38, "愛媛県")
  final case object Kochi     extends Prefecture(39, "高知県")
  final case object Fukuoka   extends Prefecture(40, "福岡県")
  final case object Saga      extends Prefecture(41, "佐賀県")
  final case object Nagasaki  extends Prefecture(42, "長崎県")
  final case object Kumamoto  extends Prefecture(43, "熊本県")
  final case object Oita      extends Prefecture(44, "大分県")
  final case object Miyazaki  extends Prefecture(45, "大分県")
  final case object Kagoshima extends Prefecture(46, "鹿児島県")
  final case object Okinawa   extends Prefecture(47, "沖縄県")

  //  val values: Seq[Prefecture] = this.prefectures
  override val values: Seq[Prefecture] = Vector(Hokkaido)

  override val defaultValue: Prefecture = Hokkaido
}
