import domain.Profile
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.MediaType

@Path("/profile")
class ProfileResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun storeNewProfile(profile: Profile): Response {
        return Response.status(Response.Status.CREATED).entity(profile).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    fun getProfiles(): List<Profile> {
        return listOf(
            Profile("testusername", "firstname", "lastname", "test@aineed.com", +3299193232)
        )
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    fun deleteProfiles(): List<Profile> {
        return listOf(
                Profile("testusername", "firstname", "lastname", "test@aineed.com", +3299193232)
        )
    }
}

