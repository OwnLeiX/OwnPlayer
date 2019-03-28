package own.lx.player.common.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import own.lx.player.OwnApplication
import own.lx.player.entity.VideoFileEntity

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
class VideoFilesDAO {

    private val mDatabaseName: String = "db_all"
    private val mTableName: String = "video_files"
    private val mVersion: Int = 1

    private val mColumnNameId: String = "_id"
    private val mColumnNameName: String = "name"
    private val mColumnNamePostFix: String = "postfix"
    private val mColumnNamePath: String = "path"
    private val mColumnNameTimestamp: String = "timestamp"
    private val mColumnNameMD5: String = "md5"
    private val mColumnNameSize: String = "size"

    private val mHelper: SQLiteOpenHelper

    init {
        mHelper = object : SQLiteOpenHelper(OwnApplication.instance, mDatabaseName, null, mVersion) {
            override fun onCreate(db: SQLiteDatabase?) {
                try {
                    db!!.execSQL(
                        "CREATE TABLE $mTableName ($mColumnNameId INTEGER PRIMARY KEY NOT NULL, $mColumnNameName VARCHAR NOT NULL,$mColumnNamePostFix VARCHAR NOT NULL,$mColumnNamePath VARCHAR NOT NULL,$mColumnNameTimestamp VARCHAR NOT NULL,$mColumnNameMD5 VARCHAR NOT NULL,$mColumnNameSize VARCHAR NOT NULL)"
                    )
                } catch (e: Exception) {
                    Log.wtf("HistoriesDAO", "create database failed", e)
                }
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            }
        }
    }

    fun insertOrUpdate(videoFile: VideoFileEntity) {
        val db = mHelper.writableDatabase
        if (db.isOpen) {
            //generate content values. In any way, we need it's timestamp, so add it now.
            val contentValues = ContentValues()
            contentValues.put(mColumnNameTimestamp, videoFile.timestamp)
            contentValues.put(mColumnNameName, videoFile.fileName)
            contentValues.put(mColumnNamePostFix, videoFile.postfix)
            contentValues.put(mColumnNameMD5, videoFile.md5)
            contentValues.put(mColumnNameSize, videoFile.size)
            //query if this video is exists.
            val cursor = db.rawQuery(
                "SELECT (?) FROM $mTableName WHERE ((?)=(?))",
                arrayOf(
                    mColumnNameId,
                    mColumnNamePath,
                    videoFile.path
                )
            )
            if (cursor.moveToNext()) {//exists, update it's timestamp.
                db.update(
                    mTableName,
                    contentValues,
                    "?=?",
                    arrayOf(
                        mColumnNameId,
                        cursor.getString(0)
                    )
                )
            } else {//does not exists, insert it.
                contentValues.put(mColumnNamePath, videoFile.path)
                db.insert(mTableName, null, contentValues)
            }
            cursor.close()
        }
    }

    fun delete(videoFile: VideoFileEntity): Int {
        var deletedRawCounts: Int = 0
        val db = mHelper.writableDatabase
        if (db.isOpen) {
            deletedRawCounts = db.delete(mTableName, "?=?", arrayOf(mColumnNamePath, videoFile.path))
        }
        return deletedRawCounts
    }
}