package org.vitrivr.vitrivrapp.data.repository

import android.net.Uri
import org.vitrivr.vitrivrapp.data.helper.SharedPreferenceHelper
import org.vitrivr.vitrivrapp.data.model.query.QueryModel

class QueryRepository {

    val QUERY_KEY = "QUERY_KEY"
    val QUERY_MODEL_KEY = "QUERY_MODEL_KEY"
    val QUERY_3D_MODEL_URI = "QUERY_3D_MODEL_URI"
    val MOTION_DRAWING_DATA = "MOTION_DRAWING_DATA"
    private val spHelper = SharedPreferenceHelper(QUERY_KEY)
    private val motionSpHelper = SharedPreferenceHelper(MOTION_DRAWING_DATA)

    fun putQueryObject(queryModel: QueryModel) {
        spHelper.putObject(QUERY_MODEL_KEY, queryModel)
    }

    fun getQueryObject(): QueryModel? {
        return spHelper.getObject(QUERY_MODEL_KEY, QueryModel::class.java)
    }

    fun putModelUri(uri: Uri?, containerId: Long) {
        if (uri == null)
            spHelper.removeKey("${QUERY_3D_MODEL_URI}_$containerId")
        else spHelper.putString("${QUERY_3D_MODEL_URI}_$containerId", uri.toString())
    }

    fun getModelUri(containerId: Long): Uri? {
        val uriString = spHelper.getString("${QUERY_3D_MODEL_URI}_$containerId") ?: return null
        return Uri.parse(uriString)
    }

    fun removeMotionData(containerID: Long) {
        val PATH_LIST_SAVE = "PATH_LIST_SAVE_$containerID"
        val ARROW_LIST_SAVE = "ARROW_LIST_SAVE_$containerID"
        motionSpHelper.removeKey(PATH_LIST_SAVE)
        motionSpHelper.removeKey(ARROW_LIST_SAVE)
    }

}