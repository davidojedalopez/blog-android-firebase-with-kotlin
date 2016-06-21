package blog.david.ojeda.firebase_login_flow

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import firebase_login_flow.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            // already signed in
            Log.d("MY_TAG", "Your email is ${(auth.currentUser as FirebaseUser).email}")
        } else {
            // not signed in
            startActivityForResult(AuthUI
                            .getInstance()
                            .createSignInIntentBuilder()
                            .build(),
                    REQUEST_CODE_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SIGN_IN) {
            if(resultCode == RESULT_OK){
                // user is signed in!
                Log.d("MY_TAG", "Sign in successful! Your email is ${FirebaseAuth.getInstance().currentUser?.email}")
            } else {
                // user is not signed in :(
            }
        }
    }




//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RC_SIGN_IN) {
//            if (resultCode == RESULT_OK) {
//                // user is signed in!
//                startActivity(new Intent(this, WelcomeBackActivity.class));
//                finish();
//            } else {
//                // user is not signed in. Maybe just wait for the user to press
//                // "sign in" again, or show a message
//            }
//        }
//    }

    companion object {
        val REQUEST_CODE_SIGN_IN = 10
    }
}
