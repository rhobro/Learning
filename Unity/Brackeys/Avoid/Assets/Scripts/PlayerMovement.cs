using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    // Components
    public Rigidbody forces;
    
    // Start is called before the first frame update
    void Start()
    {
        forces.useGravity = true;
        forces.AddForce(0, 100, 0);
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        forces.AddForce(0, 0, 1000 * Time.deltaTime);
    }
}
