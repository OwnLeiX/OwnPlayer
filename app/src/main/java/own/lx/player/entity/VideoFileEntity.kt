package own.lx.player.entity

import org.json.JSONObject

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
class VideoFileEntity(
    var id: Long,
    var fileName: String,
    var path: String,
    var postfix: String,
    var timestamp: Long,
    var md5: String,
    var size: Long
) : IEntity {

    constructor(jsonObject: JSONObject) :
            this(
                jsonObject.getLong("id"),
                jsonObject.getString("fileName"),
                jsonObject.getString("postfix"),
                jsonObject.getString("path"),
                jsonObject.getLong("timestamp"),
                jsonObject.getString("md5"),
                jsonObject.getLong("size")
            )

    override fun nonNull(): Boolean {
        return this.id >= 0 && this.fileName.isNotEmpty() && this.path.isNotEmpty() && this.postfix.isNotEmpty() && this.timestamp >= 0
    }

    fun toJSONObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("id", id)
        jsonObject.put("fileName", fileName)
        jsonObject.put("postfix", postfix)
        jsonObject.put("path", path)
        jsonObject.put("timestamp", timestamp)
        jsonObject.put("md5", md5)
        jsonObject.put("size", size)
        return jsonObject
    }


}