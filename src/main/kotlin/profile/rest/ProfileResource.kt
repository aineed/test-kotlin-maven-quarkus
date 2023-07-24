package profile.rest

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import profile.domain.Profile
import profile.service.ProfileService

@Path("/profile")
class ProfileResource(val profileService: ProfileService) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun storeNewProfile(profile: Profile): Response {
        profileService.storeProfile(profile)
        return Response.status(Response.Status.CREATED).entity(profile).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/all")
    fun getAllProfiles(): List<Profile> {
        return listOf(
                Profile("testusername", "firstname", "lastname", "test@aineed.com", +3299193232)
        )
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    fun getProfile(@HeaderParam("profileId") profileId: Int): Response {
        val profile = profileService.getProfileById(profileId)
        if (profile != null) {
            return Response.status(Response.Status.OK).entity(profile).build()
        }
        return Response.status(Response.Status.NOT_FOUND).entity(profileId).build()
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    fun deleteProfiles(@HeaderParam("profileId") profileId: Int): Response {
        val deleted = profileService.deleteProfile(profileId)
        if (deleted) {
            return Response.status(Response.Status.OK).entity("Denne profilen er slettet: $profileId").build()
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).entity("Denne profilen ble ikke slettet: $profileId").build()
    }
}

